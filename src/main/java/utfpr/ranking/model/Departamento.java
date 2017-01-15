package utfpr.ranking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
//	@OneToMany(mappedBy="departamento")
//	private Set<Funcionario> funcionarios;
	@NotNull(message="Nome é obrigatorio")
	@Column(name="nomedepartamento", unique=true)
	private String nomeDepartamento;
	@OneToOne
	@JoinColumn(name="coordenadorDepartamento", nullable = true)
	private Professor coordenador;
	

	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

//	public Set<Funcionario> getFuncionarios() {
//		return funcionarios;
//	}
//
//	public void setFuncionarios(Set<Funcionario> funcionarios) {
//		this.funcionarios = funcionarios;
//	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
}
