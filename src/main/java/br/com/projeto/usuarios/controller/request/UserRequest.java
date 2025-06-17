package br.com.projeto.usuarios.controller.request;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String fullName;
    private String email;
    private String dateOfBirth;
    private String telephoneNumber;
    private String address;

}
