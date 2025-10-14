package com.howdidyoudoit.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor      // Necessário para o JPA
@AllArgsConstructor     // Cria o construtor com todos os argumentos
public class User {
    @Id
    private String username;
    private String nomeExibicao;
    @Column(length = 512)
    private String bio;
    private String fotoPerfil;
}

