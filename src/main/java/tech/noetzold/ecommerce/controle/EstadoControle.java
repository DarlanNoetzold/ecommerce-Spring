package tech.noetzold.ecommerce.controle;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.noetzold.ecommerce.modelos.Estado;
import tech.noetzold.ecommerce.modelos.Estado;
import tech.noetzold.ecommerce.repositorios.EstadoRepositorio;
import tech.noetzold.ecommerce.repositorios.FuncionarioRepositorio;

@Controller
public class EstadoControle {
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	
	@GetMapping("/administrativo/estados/cadastrar")
	public ModelAndView cadastrar(Estado estado) {
		ModelAndView mv =  new ModelAndView("administrativo/estados/cadastro");
		mv.addObject("estado",estado);
		return mv;
	}
	
	@GetMapping("/administrativo/estados/listar")
	public ModelAndView listar() {
		ModelAndView mv=new ModelAndView("administrativo/estados/lista");
		mv.addObject("listaEstados", estadoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/estados/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Estado> estado = estadoRepositorio.findById(id);
		return cadastrar(estado.get());
	}
	
	@GetMapping("/administrativo/estados/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Estado> estado = estadoRepositorio.findById(id);
		estadoRepositorio.delete(estado.get());
		return listar();
	}
	
	@PostMapping("/administrativo/estados/salvar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result) {
		
		if(result.hasErrors()) {
			return cadastrar(estado);
		}
		estadoRepositorio.saveAndFlush(estado);
		
		return cadastrar(new Estado());
	}

}
