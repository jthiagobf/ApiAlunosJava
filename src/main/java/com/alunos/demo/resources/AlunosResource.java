package com.alunos.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.demo.models.Aluno;
import com.alunos.demo.repository.AlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Alunos")
@CrossOrigin(origins="*")
public class AlunosResource {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	@ApiOperation(value="Retorna todos os alunos cadastrados")
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/alunos/{nome}")
	@ApiOperation(value="Retorna os alunos pesquisados pelo nome (utilizar '_' ao invés de espaço)")
	public Aluno listaAlunounico(@PathVariable(value="nome")String nome){
		return alunoRepository.findByNome(nome);
	}
	
	@PostMapping("/alunos")
	@ApiOperation(value="salva um novo cadastro de aluno")
	public Aluno addAluno(@RequestBody Aluno alunos) {
		return alunoRepository.save(alunos);
	}
	
	@DeleteMapping("/alunos")
	@ApiOperation(value="deleta o cadastro de um aluno")
	public void removeAluno(@RequestBody Aluno alunos) {
		alunoRepository.delete(alunos);
	}
	
	@PutMapping("/alunos")
	@ApiOperation(value="atualiza o cadastro de um aluno")
	public Aluno atualizarAluno(@RequestBody Aluno alunos) {
		return alunoRepository.save(alunos);
	}
		
}
