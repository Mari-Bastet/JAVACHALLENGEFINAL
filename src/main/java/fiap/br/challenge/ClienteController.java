package fiap.br.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clirepo;
	
    @RequestMapping(value = "/teste", method = RequestMethod.GET)
	public List<Cliente> listarClientes(){
		return clirepo.findAll();
}
	
}