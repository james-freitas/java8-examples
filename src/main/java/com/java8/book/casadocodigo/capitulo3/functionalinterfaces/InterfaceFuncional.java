package com.java8.book.casadocodigo.capitulo3.functionalinterfaces;

/**
 * Created by XM0V on 30/05/16.
 */
public class InterfaceFuncional {


    public static void main(String[] args) {

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        };

        new Thread(r).start();

    }

}
