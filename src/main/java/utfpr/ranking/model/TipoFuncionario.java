package utfpr.ranking.model;

public enum TipoFuncionario {
	DOCENTE_ADMINISTRADOR("Docente Admnistrador"),
	DOCENTE("Docente"),
	ESTAGIARIO("Estagiário"),
	TECNICO_ADMINISTRATIVO("Técnico Administrativo");
	
	String descricao;
	TipoFuncionario(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
