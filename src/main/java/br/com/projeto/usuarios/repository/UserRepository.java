package br.com.projeto.usuarios.repository;

import br.com.projeto.usuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("SELECT user FROM User user WHERE LOWER(user.fullName) LIKE LOWER(concat('%', :fullName, '%'))")
    List<User> findByName(@Param("fullName") String fullName);*/

    List<User> findByFullNameContainingIgnoreCase(String fullName);
}
