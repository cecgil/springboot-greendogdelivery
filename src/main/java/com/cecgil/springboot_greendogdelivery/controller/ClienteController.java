package com.cecgil.springboot_greendogdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cecgil.springboot_greendogdelivery.entities.Cliente;
import com.cecgil.springboot_greendogdelivery.repositories.ClienteRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/")
    public ModelAndView list() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return new ModelAndView("clientes/list", "clientes", clientes);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Cliente cliente) {
        return new ModelAndView("clientes/view", "cliente", cliente);
    }

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Cliente cliente) {
		return "clientes/form";
	}


	@PostMapping(value = "/", params = "form")
	public ModelAndView create(@Valid Cliente cliente,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { 
            return new ModelAndView( "clientes/form","formErrors",result.getAllErrors()); 
        }
		cliente = this.clienteRepository.save(cliente);
		redirect.addFlashAttribute("globalMessage","Cliente gravado com sucesso");
		return new ModelAndView("redirect:/clientes/{cliente.id}","cliente.id",cliente.getId());
	}
    
    
    
    
    
    
}
