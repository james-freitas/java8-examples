package com.java8.curso.alura.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
		cursos.add(new CursoExercicio("C++", 55));
		
		cursos.sort(Comparator.comparingInt(CursoExercicio::getAlunos));
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		
		Optional<CursoExercicio> firstCurso = cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.findFirst();
		
		OptionalDouble average = cursos.stream()
			.mapToInt(CursoExercicio::getAlunos)
			.average();
		
		average.ifPresent(System.out::println);
		
		
		List<CursoExercicio> list = cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.collect(Collectors.toList());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		// Pegar o primeiro curso que encontrar com mais de 50 alunos
//		Optional<CursoExercicio> firstCurso = cursos.stream()
//			.filter(c -> c.getAlunos() > 50)
//			.findFirst();		
//		firstCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		// Media da quantidade de alunos de todos os cursos
//		OptionalDouble average = cursos.stream()
//			.mapToInt(CursoExercicio::getAlunos)
//			.average();
			
//		average.ifPresent(System.out::println);
		
		// Transformando um Stream filtrado em uma lista
//		List<CursoExercicio> cursosFiltrados = cursos.stream()
//			.filter(c -> c.getAlunos() > 50)
//			.collect(Collectors.toList());
//		
//		cursosFiltrados.forEach(c -> System.out.println(c.getNome()));
		
		
		
		
		
	}
	
}
