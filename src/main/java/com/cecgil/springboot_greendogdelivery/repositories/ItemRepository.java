package com.cecgil.springboot_greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cecgil.springboot_greendogdelivery.entities.ItemOrder;

@RepositoryRestResource(collectionResourceRel="itens",path="itens")
public interface ItemRepository extends JpaRepository<ItemOrder, Long> {
    
}
