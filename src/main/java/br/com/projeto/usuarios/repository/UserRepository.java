package br.com.projeto.usuarios.repository;

import br.com.projeto.usuarios.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    /*@Query("SELECT user FROM Users user WHERE LOWER(user.fullName) LIKE LOWER(concat('%', :fullName, '%'))")
    List<User> findByName(@Param("fullName") String fullName);*/

    List<Users> findByFullNameContainingIgnoreCase(String fullName);
}
