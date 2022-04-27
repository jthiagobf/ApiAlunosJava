package com.alunos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunos.demo.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	Aluno findByNome(String nome);
	

}


