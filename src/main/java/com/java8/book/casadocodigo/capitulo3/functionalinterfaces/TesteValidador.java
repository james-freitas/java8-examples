package com.java8.book.casadocodigo.capitulo3.functionalinterfaces;

public class TesteValidador {

    public static void main(String[] args) {

        Validador<String> validadorCEPAntigo = new Validador<String>() {
            @Override
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        Validador<String> validadorCEPComLambdas = valor -> {
            return valor.matches("[0-9]{5}-[0-9]{3}");
        };


        Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");


        System.out.println(validadorCEP.valida("28026-080"));
    }

}
