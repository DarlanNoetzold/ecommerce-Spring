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

import tech.noetzold.ecommerce.modelos.Cidade;
import tech.noetzold.ecommerce.modelos.Cidade;
import tech.noetzold.ecommerce.repositorios.CidadeRepositorio;
import tech.noetzold.ecommerce.repositorios.EstadoRepositorio;
import tech.noetzold.ecommerce.repositorios.FuncionarioRepositorio;

@Controller
public class NegadoControle {
	

	@GetMapping("/negadoAdministrativo")
	public ModelAndView negadoAdministrativo() {
		ModelAndView mv =  new ModelAndView("/negadoAdministrativo");
		
		return mv;
	}
	
	@GetMapping("/negadoCliente")
	public ModelAndView negadoCliente() {
		ModelAndView mv =  new ModelAndView("/negadoCliente");
		
		return mv;
	}
	
	

}
