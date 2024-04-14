package fiap.br.challenge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

	  @Query("SELECT f FROM Feedback f WHERE f.idCliente = :idCliente")
	    List<Feedback> findByClienteId(@Param("idCliente") Long idCliente);
	
}