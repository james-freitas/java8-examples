package com.java8.book.casadocodigo.capitulo9.mapeandoagrupandoparalelizando;

import com.java8.book.casadocodigo.model.Usuario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Capitulo9 {

    public static void main(String[] args) throws Exception {

        List<Usuario> usuarios = getUsuarios();
        usuarios.forEach(Usuario::tornaModerador);

        // Gerar um Stream com todas as linas dos arquivos de determinado diretório
        Stream<String> strings = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .flatMap(p -> lines(p));
        //System.out.println(strings);

        // Stream com a quantidade de linhas de cada arquivo
        LongStream lines = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .mapToLong(p -> lines(p).count());

        // List<Long> com os valores do LongStream com collect
        List<Long> lines2 = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .map(p -> lines(p).count())
                .collect(Collectors.toList());
        //System.out.println(lines2);

        // Mapear cada arquivo com sua quantidade de linhas
        Map<Path, Long> linesPerFile = new HashMap<>();

        Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .forEach(p -> linesPerFile.put(p, lines(p).count()));

        System.out.println(linesPerFile);

        // Melhorando
        Map<Path, Long> lines3 = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .collect(Collectors.toMap(
                        p -> p,
                        p -> lines(p).count()));
        System.out.println(lines3);


        // Gerar um mapa de cada arquivo paqra toda a lista de linhas contidas nos arquivos
        Map<Object, Object> content = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .collect(Collectors.toMap(
                        Function.identity(),
                        p -> lines(p).collect(Collectors.toList())));

        System.out.println(content);


        // Mapear todos os usuários utilizando seu nome como chave
        Map<String, Usuario> nameToUser = usuarios.stream().collect(Collectors.toMap(
                Usuario::getNome,
                Function.identity()));
        System.out.println(nameToUser);

    }


    public static Stream<String> lines(Path p) {

        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);
        Usuario user4 = new Usuario("James", 110);

        return Arrays.asList(user1, user2, user3, user4);
    }

}
