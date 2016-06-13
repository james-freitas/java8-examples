package com.java8.book.casadocodigo.capitulo4.defaultmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Capitulo4 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostraMensagem = u ->
                System.out.println("antes de imprimir os nomes");

        Consumer<Usuario> imprimeNome = u ->
                System.out.println(u.getNome());

        usuarios.forEach(mostraMensagem.andThen(imprimeNome));

        // removeIf usando predicado
        System.out.println();
        System.out.println("removeIf usando predicado");
        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 140;
            }
        };

        List<Usuario> usuariosLista2 = new ArrayList<>();
        usuariosLista2.add(user1);
        usuariosLista2.add(user2);
        usuariosLista2.add(user3);

        usuariosLista2.removeIf(predicado);
        usuariosLista2.forEach( u -> System.out.println(u));


        System.out.println();
        System.out.println("removeIf com Lambda sem declarar o predicado");

        // removeIf com Lambda sem declarar o predicado
        List<Usuario> usuariosLista3 = new ArrayList<>();
        usuariosLista3.add(user1);
        usuariosLista3.add(user2);
        usuariosLista3.add(user3);

        usuariosLista3.removeIf(u -> u.getPontos() > 140);
        usuariosLista3.forEach( u -> System.out.println(u));




    }
}
