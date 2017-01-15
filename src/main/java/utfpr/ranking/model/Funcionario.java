package utfpr.ranking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@NotNull(message="Código é obrigatório")
	private Long codigo;
	@NotNull(message = "Nome é obrigatório")
	private String nome;
	@NotNull(message = "Endereço é obrigatório")
	private String endereco;
	@NotNull(message = "Data de nascimento é obrigatório")
	private Date dataNascimento;
	@NotNull(message = "Tipo de funcionário é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoFuncionario tipoFuncionario;
	@ManyToOne
	@JoinColumn(name="departamento")
	private Departamento departamento;
	
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}
	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
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
	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
