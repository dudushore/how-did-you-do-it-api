package com.howdidyoudoit.api.repository;

import com.howdidyoudoit.api.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // O Spring Data JPA irá criar automaticamente a implementação deste método.
    // Ele encontra todos os projetos em que o campo 'user' tem um 'username' que corresponde ao fornecido.
    List<Project> findByUser_Username(String username);
}

