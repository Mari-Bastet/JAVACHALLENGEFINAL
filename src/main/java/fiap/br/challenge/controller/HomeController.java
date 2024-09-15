package fiap.br.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping
	public String retornaTodosBrinquedos(){
		
	return "inicial";
		
	
	}
	}
