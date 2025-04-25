package com.cecgil.springboot_greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cecgil.springboot_greendogdelivery.entities.Order;

public interface PedidoRepository extends JpaRepository<Order, Long>{
    
}
