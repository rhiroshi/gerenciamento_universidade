var PesquisaProfessor = (function(){
	function PesquisaProfessor(){
		this.inputPesquisa = $('#pesquisa');
		this.tabelaPesquisa = $('#ProcuraProfessorModal #tabela-pesquisa-professor');
	}
	
	PesquisaProfessor.prototype.iniciar = function(){
		this.inputPesquisa.keypress(function(e){
			var qry = this.inputPesquisa.val();
			$.ajax({
				url:'http://localhost:8080/cadastro-professor/query',
				method:'GET',
				data:{ nome : qry },
				success: onPesquisaRetornada.bind(this)
			});
		}.bind(this));
		
		this.tabelaPesquisa.on('click','tr', function(){
			var cols = $(this).children();
			var codigo = cols[0].innerHTML;
			$('#input-professor').val(codigo);
			$('#ProcuraProfessorModal').modal('hide');
		})
	}
	
	function onPesquisaRetornada(professores){
		this.tabelaPesquisa.empty();
		console.log('a',professores);
		professores.forEach(function(professor){
			var t = new Date(professor.dataNascimento);
			var data = t.getDate() + '/' + (t.getMonth()+1) + '/' + t.getFullYear();
			this.tabelaPesquisa.append('<tr><th>'+professor.siape+'</th><td>'+professor.nome+'</td><td>'+professor.departamento.nomeDepartamento+'</td><td>'+professor.endereco+'</td><td>'+data+'</td></tr>');
		}.bind(this))
	}
	
	return PesquisaProfessor
})();

$(function(){
	var pesquisaProfessor = new PesquisaProfessor();
	pesquisaProfessor.iniciar();
})
