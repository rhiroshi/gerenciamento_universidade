var NovaAtividade = (function(){
	function NovaAtividade(){
		this.modal = $('#NovaAtividadeModal');
		this.url = $('form').attr('action');
		this.inputDescricao = $('#input-nova-atividade-descricao');
		this.inputPeso = $('#input-nova-atividade-peso');
		this.botaoSalvar = $('#botao-nova-atividade-salvar');
		this.inputAtividadeId = $('#input-atividade-id');
		this.inputAtividadeCodigo = $('#input-atividade-codigo');
	}
	
	NovaAtividade.prototype.iniciar = (function(){
		this.modal.on('hide.bs.modal', onModalHide.bind(this));
		this.botaoSalvar.on('submit',function(e){ e.preventDefault()});
		this.botaoSalvar.on('click',function(){
			$.ajax({
				url:'http://localhost:8080/atividade/novo-66',
				method:'POST',
				contentType:'application/json',
				data : JSON.stringify({
					codigo:66,
					descricao: this.inputDescricao.val(),
					peso: this.inputPeso.val()
				}),
				success: onAtividadeSalva.bind(this)
			});
		}.bind(this))
	})
	
	function onAtividadeSalva(atividade){
		this.inputAtividadeId.val(atividade.id);
		this.inputAtividadeCodigo.val(atividade.codigo);
		$('#descricaoAtividade').html('');
		$('#descricaoAtividade').append('<strong>Descrição da atividade: </strong><span>'+atividade.descricao+'</span>');
		this.modal.modal('hide');
	}
	
	function onModalHide(){
		this.inputDescricao.val('');
		this.inputPeso.val('');
	}
	
	return NovaAtividade;
})();
$(function(){
	var novaAtividade = new NovaAtividade();
	novaAtividade.iniciar();
})