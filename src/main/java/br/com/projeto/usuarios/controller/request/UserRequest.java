package br.com.projeto.usuarios.controller.request;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String telephoneNumber;
    private String address;

}
