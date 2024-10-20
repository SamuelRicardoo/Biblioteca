package com.br.biblioteca.repository;

import com.br.biblioteca.model.AddressUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddresUserRepository extends JpaRepository<AddressUser, Long> {
}
