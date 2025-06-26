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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        try{ return new ResponseEntity<>( convertToResponse( userService.create( convertToEntity(request) ) ), HttpStatus.CREATED); }
        catch (Exception e) { return new ResponseEntity<>( HttpStatus.BAD_REQUEST ); }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> listAllUsers() {
        return new ResponseEntity<>( userService.findAll().stream().map( this::convertToResponse ).toList(), HttpStatus.OK );
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        try { return new ResponseEntity<>( convertToResponse( userService.findById( id ) ), HttpStatus.OK ); }
        catch (Exception e) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
    }*/

    @GetMapping( "/{name}")
    public ResponseEntity<List<UserResponse>> findByName( @PathVariable String name ) {
        try { return new ResponseEntity<>( userService.findByName( name ).stream().map( this::convertToResponse ).toList(), HttpStatus.OK); }
        catch( Exception e) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update( @PathVariable Long id, @RequestBody UserRequest request ) {
        try {
            Users updateUser = userService.update( id, request );
            return new ResponseEntity<>( convertToResponse( updateUser ), HttpStatus.OK );
        }catch(Exception e){ return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete( @PathVariable Long id ) {
        try { userService.delete( id ); return new ResponseEntity<>( HttpStatus.NO_CONTENT ); }
        catch ( Exception e ) { return new ResponseEntity<>( HttpStatus.BAD_REQUEST ); }
    }

    public Users convertToEntity(UserRequest request) { return mapper.map(request, Users.class); }

    public UserResponse convertToResponse(Users User) { return mapper.map(User, UserResponse.class); }
}