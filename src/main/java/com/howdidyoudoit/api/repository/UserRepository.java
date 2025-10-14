package com.howdidyoudoit.api.repository;

import com.howdidyoudoit.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // O Spring Data JPA irá criar automaticamente a implementação deste método
    // para procurar um utilizador pelo seu nome de utilizador.
    Optional<User> findByUsername(String username);
}

