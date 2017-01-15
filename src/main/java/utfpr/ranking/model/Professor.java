package utfpr.ranking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Professor {

	@Id
	private Long SIAPE;
	@NotNull
	private String nome;
	@NotNull
	private String endereco;
	@Column(name="data_nascimento")
	private Date dataNascimento;
	@ManyToOne
	@JoinColumn(name="departamento")
	private Departamento departamento;
	
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Long getSIAPE() {
		return SIAPE;
	}
	public void setSIAPE(Long sIAPE) {
		SIAPE = sIAPE;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
