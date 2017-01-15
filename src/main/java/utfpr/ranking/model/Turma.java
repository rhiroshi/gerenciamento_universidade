package utfpr.ranking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Turma {
	@Id
	@Column(name="codigo")
	private String codigo;
	@ManyToOne
	@JoinColumn(name="disciplina")
	private Disciplina disciplina;
	private Integer numeroAlunos;
	private Integer semestre;
	@OneToOne
	@JoinColumn(name="professor")
	private Professor professor;
	
	
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Integer getNumeroAlunos() {
		return numeroAlunos;
	}
	public void setNumeroAlunos(Integer numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
