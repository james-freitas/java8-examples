package com.java8.book.casadocodigo.capitulo3.functionalinterfaces;

public class DetalheLambda {

    public static void main(String[] args) {

        Runnable o = () -> {
            System.out.println("O que sou eu? Que lambda?");
        };

        System.out.println(o);

        System.out.println(o.getClass());

    }

}
