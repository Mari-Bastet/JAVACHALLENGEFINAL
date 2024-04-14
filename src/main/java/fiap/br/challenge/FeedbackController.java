package fiap.br.challenge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

	
	
	@Autowired
	private FeedbackRepository repo;
	
	
	 @RequestMapping(value="/{id}",method = RequestMethod.GET)
		public ResponseEntity<?> listarFeedbacksPorIdCliente(@PathVariable Long id){
	    	
	    	try {
	    		List<Feedback> feedbacks =  repo.findByClienteId(id);
	    		if(feedbacks.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedbacks do cliente " + id + " não encontrados");

    	        	
    	        }else {
                    return ResponseEntity.ok(feedbacks);

                }

    	}catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar feedbacks do cliente: " + e.getMessage());
    	}
	    	
	    	
	    	
	    }



}
