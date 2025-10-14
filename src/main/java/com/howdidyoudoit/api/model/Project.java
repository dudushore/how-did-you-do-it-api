package com.howdidyoudoit.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor      // Necessário para o JPA
@AllArgsConstructor     // Cria o construtor com todos os argumentos
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_username")
    private User user;

    private String titulo;
    @Column(length = 512)
    private String descricaoCurta;
    private int salvamentos;
    private Long origemProjetoId;
    @Column(length = 10000)
    private String historia;
}

