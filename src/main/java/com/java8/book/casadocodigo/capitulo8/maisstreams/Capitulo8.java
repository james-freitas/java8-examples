package com.java8.book.casadocodigo.capitulo8.maisstreams;

import com.java8.book.casadocodigo.model.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Capitulo8 {

    public static void main(String[] args) {

        List<Usuario> usuarios = getUsuarios();
        usuarios.forEach(Usuario::tornaModerador);

        // Ordenando
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());

    }

    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);
        Usuario user4 = new Usuario("James", 110);

        return Arrays.asList(user1, user2, user3, user4);
    }
}
