var Aluno = (function(){
	function Aluno(){
		this.inputAluno = $('#input-aluno');
	}
	
	Aluno.prototype.iniciar = function(){
		this.inputAluno.keyup(function(){
			var val = this.inputAluno.val();
			if(val){
				$.ajax({
					url:'http://localhost:8080/alunos/procura',
					method:'GET',
					data:{ra : val},
					success:onAlunoRetornado.bind(this)
				})
			}
		}.bind(this));
	}
	
	function onAlunoRetornado(aluno){
		var nomeAluno = $('#nome-aluno');
		if(aluno){
			nomeAluno.text(aluno.nomeAluno);
		}else{
			nomeAluno.text('Nenhum aluno encontrado');
		}
	}
	
	return Aluno;
})();

var ListarDisciplinas = (function(){
	function ListarDisciplinas(){
		this.inputDisciplina = $('#input-disciplina');
	}
	ListarDisciplinas.prototype.iniciar = function(){
			this.inputDisciplina.keyup(function(){
				var val = this.inputDisciplina.val();
				if(val){
					$.ajax({
						url:'http://localhost:8080/turma/listar',
						method:'GET',
						data:{busca : val},
						success:onTurmasRetornadas.bind(this)
					})
				}
				else{
					$('#lista-disciplina').addClass('escondido');
				}
			}.bind(this))
	}
	
	function onTurmasRetornadas(turmas){
		var lista = $('#lista-disciplina');
		var tabela = $('#lista-disciplina table');
		var tbody = $('#lista-disciplina tbody');
		tbody.empty();
		if(turmas.length > 0){
			lista.addClass('abre-lista');
			lista.removeClass('escondido');
			turmas.forEach(function(turma){
				var tr = $('<tr>').addClass('linha');
				$('<th>').text(turma.codigo).appendTo(tr);
				$('<td>').text(turma.disciplina.nomeDisciplina).appendTo(tr);
				$('<td>').text(turma.disciplina.cursos.nomeCurso).appendTo(tr);
				tr.appendTo(tabela);
			})
		}else{
			tbody.empty();
			lista.addClass('escondido');
		}
	}
	
	$('#lista-disciplina').on('click','.linha',function(){
		var cols = $(this).children();
		var codigo = cols[0].innerHTML;
		var disc = cols[1].innerHTML;
		var curs = cols[2].innerHTML;
		$('#input-disciplina').val(codigo + ', ' + disc + ', ' + curs);
		$('#valor-disciplina').val(codigo);
		$('#lista-disciplina').addClass('escondido');
	});
	
	return ListarDisciplinas;
})();



$(function(){
	var listarDisciplinas = new ListarDisciplinas();
	listarDisciplinas.iniciar();
	var aluno = new Aluno();
	aluno.iniciar();
})









//var Departamento = (function() {
//	function Departamento() {
//		this.comboDepartamento = $('#matricula-departamento');
//		this.emitter = $({});
//		this.on = this.emitter.on.bind(this.emitter);
//	}
//
//	Departamento.prototype.iniciar = function() {
//		this.comboDepartamento.on('change', onDepartamentoAlterado.bind(this));
//	}
//
//	function onDepartamentoAlterado() {
//		this.emitter.trigger('alterado', this.comboDepartamento.val());
//	}
//
//	return Departamento;
//})();
//
//var Curso = (function() {
//	function Curso(departamento) {
//		this.comboCurso = $('#matricula-curso');
//		this.departamento = departamento;
//		this.emitter = $({});
//		this.on = this.emitter.on.bind(this.emitter);
//	}
//
//	Curso.prototype.iniciar = function() {
//		this.departamento.on('alterado', onDepartamentoSelecionado.bind(this));
//		this.comboCurso.on('change', onCursoAlterado.bind(this));
//	}
//
//	function onDepartamentoSelecionado(e, id) {
//		if (id) {
//			$.ajax({
//				url : 'http://localhost:8080/cursos/getCursos',
//				method : 'GET',
//				data : {departamento : id},
//				success : onCursosRetornados.bind(this),
//			});
//		}
//	}
//	
//	function onCursosRetornados(cursos){
//		this.comboCurso.empty();
//		this.comboCurso.removeAttr('disabled');
//		this.comboCurso.html('<option>Selecione o curso</option>');
//		cursos.forEach(function(curso){
//			var optionCurso = $('<option>').val(curso.codigo).text(curso.nomeCurso);
//			this.comboCurso.append(optionCurso);
//		}.bind(this))
//	}
//
//	function onCursoAlterado(){
//		this.emitter.trigger('alterado', this.comboCurso.val());
//	}
//	return Curso;
//})();
//
////fazer para turma agora
//
//$(function() {
//	var departamento = new Departamento();
//	departamento.iniciar();
//	var curso = new Curso(departamento);
//	curso.iniciar();
//});