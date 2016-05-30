package com.java8.defaultmethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsExercicio {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do codigo");
		palavras.add("caelum");
		
		Consumer<String> consumidor = new ImprimePalavras();		
		palavras.forEach(consumidor);
		
		Comparator<String> comparador = new ComparadorPorTamanhoNovo();
		
		palavras.sort(comparador);
		palavras.forEach(consumidor);
		
	}
}

class ImprimePalavras implements Consumer<String> {

	@Override
	public void accept(String s1) {
		System.out.println(s1);
		
	}
	
}


class ComparadorPorTamanhoNovo implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() > s2.length()){
			return 1;			
		}
		if(s1.length() < s2.length()){
			return -1;
		}
		
		return 0;
	}
	
}