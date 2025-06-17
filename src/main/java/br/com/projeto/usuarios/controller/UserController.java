package br.com.projeto.usuarios.controller;

import br.com.projeto.usuarios.controller.request.UserRequest;
import br.com.projeto.usuarios.controller.response.UserResponse;
import br.com.projeto.usuarios.model.User;
import br.com.projeto.usuarios.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@Data
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        try{
            System.out.println(user.getFullName());
            System.out.println(user.getEmail());
            System.out.println(user.getAddress());
            System.out.println(user.getTelephoneNumber());
            System.out.println(user.getDateOfBirth());

            userService.save(user);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }

    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> listAllUsers() { return new ResponseEntity<>(userService.findAll(), HttpStatus.OK); }

    @GetMapping("/search-by-id/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) { return new ResponseEntity<>(userService.findById(id), HttpStatus.OK); }

    @GetMapping( "/search-by-id/name/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable String name) { return new ResponseEntity<>(userService.findByName(name), HttpStatus.OK); }
}