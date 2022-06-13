package br.com.bytecompany.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bytecompany.erp.repository.ClienteRepository;

@Controller
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public String getclientes(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll());
		return "tabelaClientes";
	}
	
	
	
}
