package com.java8.data;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DataExercicios {

	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(dataFutura);
		
		Period periodo = Period.between(hoje, dataFutura);
		System.out.println(periodo);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatter));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		LocalDate today = LocalDate.now();
//		System.out.println(today);
//		
//		LocalDate otherDate = LocalDate.of(2099, 1, 1);
//		System.out.println(otherDate);
//		
//		Period periodo = Period.between(today, otherDate);
//		System.out.println(periodo);
//		
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		System.out.println(today.format(format));
	}
	
}
