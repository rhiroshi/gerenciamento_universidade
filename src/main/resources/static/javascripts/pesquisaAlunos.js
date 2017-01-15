var pesquisaAluno = (function(){
	this.inputPesquisa = $('#input-procura-aluno');
	this.tabelaPesquisa = $('#tabela-alunos tbody');
	this.inputPesquisa.keypress(function(e){
		var qry = inputPesquisa.val();
		$.ajax({
			url:'http://localhost:8080/alunos/procuraPorNome',
			method:'GET',
			data:{ nome : qry },
			success: onPesquisaRetornada.bind(this)
		});
	});
	
	function onPesquisaRetornada(alunos){
		tabelaPesquisa.empty();
		alunos.forEach(function(aluno){
			tabelaPesquisa.append('<tr><th>'+aluno.ra+'</th><td>'+aluno.nomeAluno+'</td><td>'+aluno.curso.nomeCurso+'</td><td><a id="okay"><i class="glyphicon glyphicon-ok"/></a></td></tr>');
		}.bind(this))
	}
	
		this.tabelaPesquisa.on('click','tr',function(){
			var inputAluno = $('#input-aluno');
			var nomeAluno = $('#nome-aluno');
			var cols = $(this).children();
			var codigo = cols[0].innerHTML;
			var nome = cols[1].innerHTML;
			inputAluno.val(codigo);
			nomeAluno.text(nome);
			$('#ProcuraAlunoModal').modal('hide');
		})
	
})();
