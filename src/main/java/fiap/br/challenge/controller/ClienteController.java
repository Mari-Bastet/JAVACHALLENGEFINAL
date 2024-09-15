package fiap.br.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fiap.br.challenge.domain.Cliente;
import fiap.br.challenge.repository.ClienteRepository;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clirepo;
	
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
    @RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listarClientes(){
		return clirepo.findAll();
}

    @RequestMapping(value="/adicionar",method = RequestMethod.GET)
	public String retornaTemplateAdicionarCliente(Model model){
    	
    	try {
    		
    	    model.addAttribute("cliente", new Cliente());
        return "/usuario/cadastro";
		
    	}catch(Exception e) {
    		return "/erro";
    	}
    }
    
    @RequestMapping(value="/adicionar",method = RequestMethod.POST)
	public String adicionarCliente(@ModelAttribute Cliente cliente){
    	
    	try {
		clirepo.save(cliente);
        return "/inicial";
		
    	}catch(Exception e) {
    		return "redirect:/erro";
    	}
    }
    
    @RequestMapping(value="/login",method = RequestMethod.GET)
	public String carregaTemplateLoginCliente(){
    	
      return "/usuario/login";
    }
    
    @RequestMapping(value="/login/realizarLogin",method = RequestMethod.POST)
	public String tentativaLoginCliente(@RequestParam("email")String email
										,@RequestParam("senha")String senha
			                            ){
    	
    	try {
		Long idCliente = clirepo.buscaClienteLogin(email, senha);
		
		logger.debug("email" + email + "senha" + senha + "idcliente" + idCliente);
		if (idCliente != null) {
	        return "/inicial";
			
		}else {
			
	        return "redirect:/clientes/login";
		}
		
		
    	}catch(Exception e) {
    		return "redirect:/erro";
    	}
    }
   
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
    	
    	try {
        clirepo.deleteById(id);
        return ResponseEntity.ok("Cliente eliminado com sucesso");

    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover cliente" + e.getMessage());

    	}
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> consultarclientePorId(@PathVariable Long id) {
    	try {
    		 Optional<Cliente> cli = clirepo.findById(id);
    	        if(cli.isPresent()) {
                    return ResponseEntity.ok(cli.get());

    	        	
    	        }else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
                }

    	}catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao consultar cliente por ID: " + e.getMessage());
    	}
    }
}