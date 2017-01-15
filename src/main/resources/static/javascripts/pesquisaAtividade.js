var PesquisaAtividade = (function(){
	function PesquisaAtividade(){
		this.tabelaPesquisa = $('#tabela-pesquisa-atividade');
	}
	PesquisaAtividade.prototype.iniciar = function(){
		$.ajax({
			url:'http://localhost:8080/atividades/findAll',
			method:'GET',
			success: onPesquisaRetornada.bind(this)
		});
		
		this.tabelaPesquisa.on('click','tr', function(){
			var id = $(this).attr('id');
			var codigo = $(this).find('th').text();
			if(codigo == 66){
				$('#ProcuraAtividadeModal').modal('hide');
				$('#NovaAtividadeModal').modal('show');
			}else{
				var descricao = $(this).find('td').get(0).innerHTML;
				$('#input-atividade-id').val(id);
				$('#input-atividade-codigo').val(codigo);
				$('#descricaoAtividade').html('');
				$('#descricaoAtividade').append('<strong>Descrição da atividade: </strong><span>'+descricao+'</span>');
				$('#ProcuraAtividadeModal').modal('hide');
			}
		})
		
	}
	
	function onPesquisaRetornada(atividades){
		this.tabelaPesquisa.empty();
		atividades.forEach(function(atividade){
			this.tabelaPesquisa.append('<tr id="'+atividade.id+'"><th>'+atividade.codigo+'</th><td>'+atividade.descricao+'</td><td>'+atividade.peso+'</td></tr>');
		}.bind(this))
	}
	
	return PesquisaAtividade;
})();

$(function(){
	var pesquisaAtividade = new PesquisaAtividade();
	pesquisaAtividade.iniciar();
})