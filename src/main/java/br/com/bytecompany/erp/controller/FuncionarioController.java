package br.com.bytecompany.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bytecompany.erp.repository.FuncionarioRepository;

public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionarios")
	public String getFuncionarios(Model model) {
		model.addAttribute("funcionarios", funcionarioRepository);
		return "tabelaFuncionarios";
	}
	
}
