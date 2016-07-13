package com.java8.book.casadocodigo.capitulo8.maisstreams;

import com.java8.book.casadocodigo.model.Usuario;

import java.util.*;

public class FlatDemonstration {
    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);
        Usuario user4 = new Usuario("James", 110);

        Grupo englishSpeakers = new Grupo();
        englishSpeakers.add(user1);
        englishSpeakers.add(user2);

        Grupo spanishSpeakers = new Grupo();
        spanishSpeakers.add(user2);
        spanishSpeakers.add(user3);

        List<Grupo> groups = Arrays.asList(englishSpeakers, spanishSpeakers);

        // obter todos os usuarios desses grupos
        groups.stream()
                .flatMap(g -> g.getUsuarios().stream())
                .distinct()
                .forEach(System.out::println);
    }

}


class Grupo {

    private Set<Usuario> usuarios = new HashSet<>();

    public void add(Usuario u) {
        usuarios.add(u);
    }

    public Set<Usuario> getUsuarios() {
        return Collections.unmodifiableSet(this.usuarios);
    }

}