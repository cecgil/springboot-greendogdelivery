package com.cecgil.springboot_greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cecgil.springboot_greendogdelivery.entities.ItemOrder;

public interface ItemRepository extends JpaRepository<ItemOrder, Long> {
    
}
