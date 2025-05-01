package com.cecgil.springboot_greendogdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cecgil.springboot_greendogdelivery.entities.Client;
import com.cecgil.springboot_greendogdelivery.repositories.ClientRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Client client) {
        return new ModelAndView("clientes/view", "cliente", client);
    }

    @GetMapping("/novo")
    public String createForm(@ModelAttribute Client client) {
        return "clientes/form";
    }

    @PostMapping(params = "form")
    public ModelAndView create(@Valid Client client, BindingResult result, RedirectAttributes redirect) {
        if(result.hasErrors()) {
            return new ModelAndView("clientes/form", "formErros", result.getAllErrors());
        }

        client = this.clientRepository.save(client);
        redirect.addFlashAttribute("globalMessage", "Cliente salvo com sucesso");
        return new ModelAndView("redirect:/clientes/{cliente.id}", "cliente.id", client.getId());
    }
    
    
    
    
    
    
}
