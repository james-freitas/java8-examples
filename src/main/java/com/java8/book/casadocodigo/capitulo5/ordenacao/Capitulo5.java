package com.java8.book.casadocodigo.capitulo5.ordenacao;

import com.java8.book.casadocodigo.model.Usuario;

import java.util.*;

public class Capitulo5 {

    public static void main(String[] args) {

        List<Usuario> usuarios = getUsuarios();


        System.out.println("Ordenando sem lambda");
        Comparator<Usuario> comparator = new Comparator<Usuario>() {

            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };

        Collections.sort(usuarios, comparator);
        System.out.println();


        System.out.println("Ordenando com lambda");
        Comparator<Usuario> comparator1 = (u1, u2) -> u1.getNome().compareTo(u2.getNome());

        Collections.sort(usuarios, comparator1);

        // Em uma mesma linha
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        // Maiúsculas ou minúsculas
        Collections.sort(usuarios, (u1, u2) ->
            String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome()));

    }

    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);

        return Arrays.asList(user1, user2, user3);
    }

}
