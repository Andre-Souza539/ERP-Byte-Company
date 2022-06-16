package br.com.bytecompany.erp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.bytecompany.erp.orm.Cliente;
import br.com.bytecompany.erp.repository.ClienteRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cadastro")
	public String cadastroForm(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cadastroForm";
	}


	@PostMapping("/salvar")
	public String processForm(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return "cadastroForm";
		}
		clienteRepository.save(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/delete/{id}")
	public String deleteCliente(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/edit/{id}")
	public String editCliente(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente", clienteRepository.findById(id));		
		return "updateForm";
	}
	
	
	@GetMapping("/save")
	public String updateForm(Cliente cliente) {		
		clienteRepository.save(cliente);
		return "redirect:/clientes";
	}
}
	
