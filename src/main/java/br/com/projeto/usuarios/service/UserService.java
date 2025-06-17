package br.com.projeto.usuarios.service;

import br.com.projeto.usuarios.controller.response.UserResponse;
import br.com.projeto.usuarios.model.User;
import br.com.projeto.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public UserResponse save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findByName(String name) { return userRepository.findByFullNameContainingIgnoreCase(name); }


}
