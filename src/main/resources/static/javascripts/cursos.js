var Departamento = (function(){
	function Departamento(){
		this.comboDepartamento = $('#aluno-departamento');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	Departamento.prototype.iniciar = function(){
		this.comboDepartamento.on('change', onDepartamentoAlterado.bind(this) );
	}
	
	function onDepartamentoAlterado(){
		this.emitter.trigger('alterado', this.comboDepartamento.val());
	}
	
	return Departamento;
})();

var Cursos = (function(){
	function Cursos(departamento){
		this.comboCursos = $('#aluno-curso');
		this.departamento = departamento;
	}
	
	Cursos.prototype.iniciar = function(){
		this.departamento.on('alterado', onDepartamentoSelecionado.bind(this) );
	}
	
	function onDepartamentoSelecionado(evento, id){
		if(id){
			$.ajax({
				url: 'http://localhost:8080/GetCursos',
				method: 'GET',
				data: { id: id},
				success: onCursosRetornados.bind(this)
			});
		}else{
			this.comboCursos.html('');
			this.comboCursos.html('<option>Nenhum Curso disponível</option>');
			this.comboCursos.attr('disabled', 'disabled');
		}
	}
	
	function onCursosRetornados(cursos){
		this.comboCursos.html('');
		this.comboCursos.removeAttr('disabled');
		this.comboCursos.html('<option>Selecione o Curso</option>');
		cursos.forEach(function(curso){
			var optionCurso = $('<option>').val(curso.codigo).text(curso.nomeCurso);
			this.comboCursos.append(optionCurso);
		}.bind(this))
	}
	
	return Cursos;
})();

$(function(){
	var departamento = new Departamento();
	departamento.iniciar();
	var cursos = new Cursos(departamento);
	cursos.iniciar();
});

$(document).ready(function($){
	var mascara = $('#input-funcionario-nascimento');
	mascara.mask('00/00/0000');
});