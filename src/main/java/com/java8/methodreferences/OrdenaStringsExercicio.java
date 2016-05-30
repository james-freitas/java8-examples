package com.java8.methodreferences;

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
		
	
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		OutroComparador outroComparador = new OutroComparador();
		palavras.sort(outroComparador);
		
		palavras.forEach(System.out::println);
		
	}
}

class OutroComparador implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.charAt(2) < s2.charAt(2)) {
			return -1;
		}
		if(s2.charAt(2) > s2.charAt(2)) {
			return 1;
		}
		return 0;
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
