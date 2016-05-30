package com.java8.book.casadocodigo.capitulo3.functionalinterfaces;

@FunctionalInterface
public interface Validador<T> {

    boolean valida(T t);

}
