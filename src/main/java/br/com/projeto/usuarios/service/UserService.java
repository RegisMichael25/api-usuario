package br.com.projeto.usuarios.service;

import br.com.projeto.usuarios.controller.request.UserRequest;
import br.com.projeto.usuarios.model.Users;
import br.com.projeto.usuarios.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();

    public Users create(Users user) {
        return userRepository.save(user);
    }

    public List<Users> findAll() { return userRepository.findAll(); }

    public Users findById(Long id) {
        return userRepository.findById(id).get();
    }

    public Users update(Long id, UserRequest request) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        mapper.map(request, existingUser);
        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(user.getId());
    }

    public List<Users> findByName(String name) { return userRepository.findByFullNameContainingIgnoreCase(name); }
}
