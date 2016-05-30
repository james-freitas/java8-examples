package com.java8.curso.alura.defaultmethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("casa do codigo");
		palavras.add("caelum");
		
		Collections.sort(palavras);
		System.out.println(palavras);
		
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		palavras.sort(comparador);
		//Collections.sort(palavras, comparador);
		//System.out.println(palavras);
		
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
		
		
//		Comparator<String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras, comparador);
		
//		palavras.sort(comparador);
//		
//		System.out.println(palavras);
		
//		for (String p : palavras) {
//			System.out.println(p);
//		}
		
	//	Consumer<String> consumidor = new ImprimeNaLinha();
//		palavras.forEach(consumidor);
		
	}
}


class ComparadorDeStringPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()){
			return -1;
		}
		if(s1.length() > s2.length()){
			return 1;
		}
		return 0;
	}
	
}

class ConsumidorDeString implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}

//class ImprimeNaLinha implements Consumer<String> {
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}
//	
//}
//
//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if(s1.length() < s2.length())
//			return -1;
//		if(s1.length() > s2.length())
//			return 1;
//		return 0;
//	}
//	
//}
