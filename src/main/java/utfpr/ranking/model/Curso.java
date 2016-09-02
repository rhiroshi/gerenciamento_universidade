package utfpr.ranking.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@NotNull(message="Nome do curso é obrigatório")
	@Column(name="nomecurso", unique=true)
	private String nomeCurso;
	@ManyToOne
	@JoinColumn(name="departamento")
	private Departamento departamento;
	@OneToMany(mappedBy="curso")
	private Set<Aluno> alunos;
	@ManyToMany(mappedBy="cursos")
	private Set<Disciplina> disciplinas;
	
	public Set<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public String toString(){
		return Integer.toString(codigo);
	}
	
}
