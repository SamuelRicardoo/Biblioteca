package com.br.biblioteca.repository;

import com.br.biblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerifierExistEmail extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
