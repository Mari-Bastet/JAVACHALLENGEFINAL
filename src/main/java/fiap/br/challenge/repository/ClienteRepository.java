package fiap.br.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fiap.br.challenge.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT c FROM Cliente c LEFT JOIN Compra cm ON cm.cliente.id = c.id")
    List<Cliente> buscaClientesSemCompra();

	@Query("SELECT c.id FROM Cliente c where upper(email) = upper(:email) and senha = :senha")
    Long buscaClienteLogin(@Param("email") String email
    					   ,@Param("senha") String senha
    					   );
	@Query("SELECT c FROM Cliente c where upper(email) = upper(:email)") //and senha = :senha
    Optional<Cliente> findByUsername(@Param("email") String email
    					   //,@Param("senha") String senha
    					   );
}