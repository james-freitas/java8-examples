package com.java8.book.casadocodigo.capitulo6.methodreferences;

import com.java8.book.casadocodigo.model.Usuario;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Capitulo6 {

    public static void main(String[] args) {

        List<Usuario> usuarios = getUsuarios();

        usuarios.forEach(Usuario::tornaModerador);


        // 2
        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;
        usuarios.forEach(tornaModerador);


        // 3
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        // 4
        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));

        // Compondo comparators

        // 1
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));

        // 2
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));

        // 3 - Ordenar pelos pontos e no caso de empate ordenar pelo nome
        //Comparator<Usuario> c = Comparator.comparingInt(Usuario::getPontos)
        //        .thenComparing(Usuario::getNome);


        // 4 - Ordenar pelos pontos e no caso de empate ordenar pelo nome evitando boxing
        //usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));

        // 5 - nulls last
        //usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getNome)));

        // 6 ordenar por pontos, porém na ordem decrescente
        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());


        // 6.4 Referenciando métodos de instância

        // 1
        Usuario rodrigo = new Usuario("Rodrigo Turini", 50);
        Runnable bloco = rodrigo::tornaModerador;
        bloco.run();

        // 2
        Runnable bloco1 = rodrigo::tornaModerador;
        Runnable bloco2 = () -> rodrigo.tornaModerador();

        // 3
        Consumer<Usuario> consumer = Usuario::tornaModerador;
        consumer.accept(rodrigo);

        // 4 Equivalencia
        Consumer<Usuario> consumer1 = Usuario::tornaModerador;
        Consumer<Usuario> consumer2 = u -> u.tornaModerador();


    }

    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);

        return Arrays.asList(user1, user2, user3);
    }
}
