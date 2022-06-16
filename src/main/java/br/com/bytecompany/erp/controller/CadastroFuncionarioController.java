package br.com.bytecompany.erp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.bytecompany.erp.orm.Funcionario;
import br.com.bytecompany.erp.repository.FuncionarioRepository;

@Controller
public class CadastroFuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/cadastroFuncionario")
	public String cadastroFuncionarioForm(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "cadastroFuncionarioForm";
	}
	
	@PostMapping("/salvarFuncionario")
	public String processForm(@Valid Funcionario funcionario, BindingResult result) {
		if(result.hasErrors()) {
			return "cadastroFuncionarioForm";
		}
		funcionarioRepository.save(funcionario);
		return "redirect:/funcionarios";
	}
	
	@GetMapping("/funcionario/delete/{id}")
	public String deleteFuncionario(@PathVariable Integer id) {
		funcionarioRepository.deleteById(id);
		return "redirect:/funcionarios";
	}
	
	@GetMapping("/funcionario/edit/{id}")
	public String editCliente(@PathVariable Integer id, Model model) {
		model.addAttribute("funcionario", funcionarioRepository.findById(id));		
		return "updateFuncionarioForm";
	}
	
	@GetMapping("/saveFuncionario")
	public String updateForm(Funcionario funcionario) {		
		funcionarioRepository.save(funcionario);
		return "redirect:/funcionarios";
	}
	
	
	
	
	
}
