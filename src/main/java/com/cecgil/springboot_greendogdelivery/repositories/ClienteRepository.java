package com.cecgil.springboot_greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cecgil.springboot_greendogdelivery.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
