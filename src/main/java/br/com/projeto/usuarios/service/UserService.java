package br.com.projeto.usuarios.service;

import br.com.projeto.usuarios.model.Users;
import br.com.projeto.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public Users create(Users user) {
        return userRepository.save(user);
    }

    public List<Users> findAll() { return userRepository.findAll(); }

    public Users findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<Users> findByName(String name) { return userRepository.findByFullNameContainingIgnoreCase(name); }
}
