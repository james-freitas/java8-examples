package com.java8.colecoes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CursoExercicio {
	private String nome;
	private int alunos;

	public CursoExercicio(String nome, int alunos) {
		this.alunos = alunos;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

}

public class ExemploCursosExercicio {

	public static void main(String[] args) {
		
		List<CursoExercicio> cursos = new ArrayList<>();
		cursos.add(new CursoExercicio("Python", 45));
		cursos.add(new CursoExercicio("JavaScript", 150));
		cursos.add(new CursoExercicio("Java 8", 113));
		cursos.add(new CursoExercicio("C", 55));
		
		cursos.sort(Comparator.comparing(CursoExercicio::getAlunos));
		
		
		cursos.stream()
			.filter(curso -> curso.getAlunos() > 50)
			.forEach(c -> System.out.println(c.getNome()));
		
		
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.map(CursoExercicio::getAlunos)
			.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		//cursos.sort(Comparator.comparing(CursoExercicio::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		
//		cursos.stream()
//			.filter(c -> c.getAlunos() > 50)
//			.forEach(c -> System.out.println(c.getNome()));
		
		
//		cursos.stream()
//			.map(c -> c.getNome())
//			.forEach(System.out::println);
		
//		cursos.stream()
//			.filter(c -> c.getAlunos() > 50)
//			.map(c -> c.getAlunos())
//			.forEach(System.out::println);
		
		
	}
	
}
