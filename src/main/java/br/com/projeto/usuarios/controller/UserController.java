package br.com.projeto.usuarios.controller;

import br.com.projeto.usuarios.controller.request.UserRequest;
import br.com.projeto.usuarios.controller.response.UserResponse;
import br.com.projeto.usuarios.model.Users;
import br.com.projeto.usuarios.service.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        try{
            return new ResponseEntity<>( convertToResponse( userService.create( convertToEntity(request) ) ), HttpStatus.CREATED);
        }catch (Exception e) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }

    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> listAllUsers() {
        List<UserResponse> list = userService.findAll().stream().map(this::convertToResponse).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search-by/id/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) { return new ResponseEntity<>(userService.findById(id), HttpStatus.OK); }

    @GetMapping( "/search-by/name/{name}")
    public ResponseEntity<List<Users>> findByName(@PathVariable String name) { return new ResponseEntity<>(userService.findByName(name), HttpStatus.OK); }

    public Users convertToEntity(UserRequest request) { return mapper.map(request, Users.class); }

    public UserResponse convertToResponse(Users User) { return mapper.map(User, UserResponse.class); }
}