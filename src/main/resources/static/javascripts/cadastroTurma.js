$('document').ready(
		function($) {
			var botao = $('.btn-nova-turma');
			botao.click(function() {
				$('.nova-turma').attr('style', '');
			});

			var pesquisa = (function() {
				var tabela = $('#tabela-pesquisa-t');
				var select = $('#turma-disciplina');
				select.on('change', function() {
					tabela.empty();
					var val = select.val();
					if (val) {
						$.ajax({
							url : 'http://localhost:8080/cadastro-turma/query',
							method : 'GET',
							data : {
								disciplina : val
							},
							success : onTurmaRetornada.bind(this)
						});
					}
				});

				function onTurmaRetornada(turmas) {
					turmas.forEach(function(turma) {
						tabela.append('<tr><th>' + turma.codigo + '</th><td>'
								+ turma.disciplina.nomeDisciplina + '</td><td>'+turma.semestre+'</td><td>'
								+ turma.numeroAlunos + '</td><td>'+turma.professor.nome+'</td></tr>');
					}.bind(this))
				}

			})();

		});