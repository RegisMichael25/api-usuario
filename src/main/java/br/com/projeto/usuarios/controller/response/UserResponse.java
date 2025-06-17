package br.com.projeto.usuarios.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String fullName;
    private String email;
    private String dateOfBirth;
    private String telephoneNumber;
    private String address;

}
