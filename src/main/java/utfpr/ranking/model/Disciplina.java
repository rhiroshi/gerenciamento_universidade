package utfpr.ranking.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	@NotNull(message="Nome é obrigatório")
	@Column(name="nomedisciplina")
	private String nomeDisciplina;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="disciplina_curso",joinColumns = @JoinColumn(name="disciplina", referencedColumnName="codigo"), inverseJoinColumns=@JoinColumn(name="curso",referencedColumnName="codigo"))
	private Set<Curso> cursos;
	

	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
}
