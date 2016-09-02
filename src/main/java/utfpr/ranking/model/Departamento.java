package utfpr.ranking.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@OneToMany(mappedBy="departamento")
	private Set<Funcionario> funcionarios;
	@NotNull(message="Nome é obrigatorio")
	@Column(name="nomedepartamento", unique=true)
	private String nomeDepartamento;
	@OneToMany(mappedBy="departamento")
	private Set<Curso> cursos;
	@OneToMany(mappedBy="departamento")
	private Set<Aluno> alunos;

	
	
	public Set<Curso> getCursos() {
		return cursos;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
}
