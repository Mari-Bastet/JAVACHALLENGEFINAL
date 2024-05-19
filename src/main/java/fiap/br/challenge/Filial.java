package fiap.br.challenge;
 
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@SequenceGenerator(name = "FILIAL_SEQ", sequenceName = "TB_FILIAL_SEQ", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_FILIAL")
public class Filial {
 
	@Id()
	@Column(name = "ID_FILIAL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILIAL_SEQ")
	private Long idFilial;
 
	@Column
	@NotNull
	@Max(255)
	private String nome;
 
	@Column
	@NotNull
	@Max(2)
	private String estado;
 
	@Column
	@NotNull
	@Max(100)
	private String cidade;
 
	@Column
	@NotNull
	@Max(8)
	private String cep;
 
	@Column
	@NotNull
	@Max(255)
	private String endereco;
	
	@Column(name = "COD_FILIAL")
	@NotNull
	@Max(255)
	private String codFilial;
	
	@OneToMany(mappedBy = "filial",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Compra> compras;
	
	public Filial(Long idFilial, @NotNull @Max(255) String nome, @NotNull @Max(2) String estado,
			@NotNull @Max(100) String cidade, @NotNull @Max(8) String cep, @NotNull @Max(255) String endereco,
			@NotNull @Max(255) String codFilial) {
		super();
		this.idFilial = idFilial;
		this.nome = nome;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.endereco = endereco;
		this.codFilial = codFilial;
	}
	
	public Filial(){}
 
}