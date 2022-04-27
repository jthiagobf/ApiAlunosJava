package com.alunos.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.demo.models.Aluno;
import com.alunos.demo.repository.AlunoRepository;


@RestController
@RequestMapping(value="/api")
public class AlunosResource {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/alunos/{nome}")
	public Aluno listaAlunounico(@PathVariable(value="nome")String nome){
		return alunoRepository.findByNome(nome);
	}
	
	@PostMapping("/alunos")
	public Aluno addAluno(@RequestBody Aluno alunos) {
		return alunoRepository.save(alunos);
	}
		
}
