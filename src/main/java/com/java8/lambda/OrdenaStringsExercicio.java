package com.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

public class OrdenaStringsExercicio {

	public static void main(String[] args) {
		//String c;
		//char x = c.indexOf(1);
		
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("Freitas");
		palavras.add("James");
		palavras.add("Correia");
		palavras.add("Daniel");
		
		palavras.forEach(System.out::println);
		
//		palavras.sort((s1, s2) -> {
//			if(s1.length() < s2.length()){
//				return -1;
//			}
//			if(s1.length() > s2.length()){
//				return 1;
//			}
//			return 0;
//		});
//		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		System.out.println(palavras);
		
		new Thread(() -> System.out.println("Executando um Runnable")).run();
		
		
		// Listando com default method
//		System.out.println("");
//		System.out.println("Default method");
//		System.out.println("----------------------");
//		palavras.forEach(palavra -> System.out.println(palavra));
//		
//		// Comparator with lambda #1
//		System.out.println("");
//		System.out.println("Comparator #1");
//		System.out.println("----------------------");
//		palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length())); 
//		System.out.println(palavras);
//
//		// Thread with lambda
//		System.out.println("");
//		System.out.println("Lambda com Runnable");	
//		System.out.println("----------------------");
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Executando um Runnable verboso");
//			}
//		}).start();
//		
//		new Thread(() -> System.out.println("Executando um Runnable")).run();
//		
//		
//		// Comparator with lambda #2
//		System.out.println("");
//		System.out.println("Comparator #2");
//		System.out.println("----------------------");
//		palavras.sort(Comparator.comparing(s -> s.length()));
//		System.out.println(palavras);
//		
//		// Comparator with lambda #3 (static import)
//		System.out.println("");
//		System.out.println("Comparator #3");
//		System.out.println("----------------------");
//		palavras.sort(comparing(s -> s.length()));
//		System.out.println(palavras);
//
//		// Comparator with lambda #4 other criteria
//		System.out.println("");
//		System.out.println("Comparator #4");
//		System.out.println("----------------------");
//		palavras.sort(comparing(s -> s.indexOf(2)));
//		System.out.println(palavras);
		
	}
}

class ComparadorPorTamanho2 implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}
