package tech.noetzold.ecommerce.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalControle {
	
	@GetMapping("/administrativo")
	public String acessarPrincipal() {
		return "administrativo/home";
	}
}
