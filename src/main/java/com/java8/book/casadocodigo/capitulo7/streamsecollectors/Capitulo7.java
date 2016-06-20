package com.java8.book.casadocodigo.capitulo7.streamsecollectors;

import com.java8.book.casadocodigo.model.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Capitulo7 {

    public static void main(String[] args) {

        List<Usuario> usuarios = getUsuarios();
        usuarios.forEach(Usuario::tornaModerador);


        // Tornando moderadores os 10 usuários com mais  pontos
        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
        usuarios
            .subList(0, 3) // substituir 3 por 10
            .forEach(Usuario::tornaModerador);


        // tornando moderadores os usuários com mais de 100 pontos
        Stream<Usuario> stream = usuarios.stream();
        stream.filter(u -> u.getPontos() > 100);


        // simpler
        usuarios.stream()
            .filter( u -> u.getPontos() > 100);

        //usuarios.forEach(System.out::println);

        //Stream<Usuario> stream2 = usuarios.stream().filter(u -> u.getPontos() > 100);
        //stream2.forEach(System.out::println);


        // simpler
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(System.out::println);


        // filtrar esses usuários e torná-losmoderadores
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(Usuario::tornaModerador);

        // filtrar usuarios que sao moderadores
        usuarios.stream()
                .filter(u -> u.isModerador());

        // simpler
        usuarios.stream()
                .filter(Usuario::isModerador);



    }


    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);
        Usuario user4 = new Usuario("James", 110);

        return Arrays.asList(user1, user2, user3, user4);
    }

}
