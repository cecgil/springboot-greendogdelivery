package com.cecgil.springboot_greendogdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cecgil.springboot_greendogdelivery.entities.Client;
import com.cecgil.springboot_greendogdelivery.repositories.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public ModelAndView list() {
        Iterable<Client> clientes = clientRepository.findAll();
        return new ModelAndView("clientes/list", "clientes", clientes);
    }
    
    
}
