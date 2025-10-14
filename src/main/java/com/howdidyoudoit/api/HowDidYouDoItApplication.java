package com.howdidyoudoit.api;

import com.howdidyoudoit.api.model.Project;
import com.howdidyoudoit.api.model.User;
import com.howdidyoudoit.api.repository.ProjectRepository;
import com.howdidyoudoit.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class HowDidYouDoItApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowDidYouDoItApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://127.0.0.1:5500");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, ProjectRepository projectRepository) {
        return args -> {
            User user1 = new User("ana.dev", "Ana Dev", "Desenvolvedora Frontend e entusiasta de projetos DIY.", "https://placehold.co/100x100/A78BFA/FFFFFF?text=AD");
            User user2 = new User("beto.construtor", "Beto Construtor", "Marcenaria, jardinagem e tudo que envolva criar com as mãos.", "https://placehold.co/100x100/FBBF24/FFFFFF?text=BC");
            User user3 = new User("carlos.chef", "Carlos Chef", "Explorando o mundo da culinária, uma receita de cada vez.", "https://placehold.co/100x100/F87171/FFFFFF?text=CC");
            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            // CORREÇÃO: Adicionado 'null' para o campo 'id' nos construtores, pois ele é gerado automaticamente.
            Project p1 = new Project(null, user1, "Criei um Portfólio Pessoal com React e Tailwind", "Um guia passo a passo para construir um site de portfólio moderno e responsivo.", 128, null, "## A Motivação...");
            Project p2 = new Project(null, user2, "Horta Vertical com Garrafas PET", "Uma solução sustentável e barata para cultivar temperos em apartamentos.", 256, null, "## O Problema...");
            Project p3 = new Project(null, user3, "Pão de Fermentação Natural para Iniciantes", "Como criar seu próprio fermento (levain) e assar um pão delicioso.", 432, null, "### A Jornada da Fermentação...");
            Project p4 = new Project(null, user1, "Horta Vertical com Irrigação Automática", "Adaptando o projeto do Beto com um toque de tecnologia usando Arduino.", 78, 2L, "## A Inspiração...");
            projectRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
        };
    }
}

