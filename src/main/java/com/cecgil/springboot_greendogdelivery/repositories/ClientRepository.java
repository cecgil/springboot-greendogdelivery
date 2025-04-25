package com.cecgil.springboot_greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cecgil.springboot_greendogdelivery.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
