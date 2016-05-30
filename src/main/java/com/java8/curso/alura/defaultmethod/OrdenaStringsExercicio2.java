package com.java8.curso.alura.defaultmethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsExercicio2 {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do codigo");
		palavras.add("caelum");
	
		
		Consumer<? super String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
		};
		
		palavras.forEach(consumer);
		
		
		Comparator<String> comparator = new ComparadorDeTamanho();
		palavras.sort(comparator);
		palavras.forEach(consumer);
		
		
	}
}


class ComparadorDeTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length() ){
			return -1;
		}
		if (s1.length() > s2.length() ){
			return 1;
		}
		return 0;	}


	
}

