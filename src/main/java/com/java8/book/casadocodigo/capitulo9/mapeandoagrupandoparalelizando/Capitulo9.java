package com.java8.book.casadocodigo.capitulo9.mapeandoagrupandoparalelizando;

import com.java8.book.casadocodigo.model.Usuario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Capitulo9 {

    public static void main(String[] args) throws Exception {

        List<Usuario> usuarios = getUsuarios();
        //usuarios.forEach(Usuario::tornaModerador);

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


        // Obter mapa que a chave seja a pontuacao e o valor a lista de usuarios com aquela pontuacao
        Map<Integer, List<Usuario>> pontuacao = new HashMap<>();

        for(Usuario u: usuarios) {
            pontuacao
                    .computeIfAbsent(u.getPontos(), user -> new ArrayList<>())
                    .add(u);
        }
        System.out.println(pontuacao);
        System.out.println();


        // Mesmo do acima usando streams
        Map<Integer, List<Usuario>> pontuacao2 =  usuarios
                .stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));



        // Particionar todos os usarios entre moderadores e nao moderadores com partitionBy
        Map<Boolean, List<Usuario>> moderadores = usuarios
                .stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));
        System.out.println(moderadores);
        System.out.println();


        // lista com os nomes dos usuários
        Map<Boolean, List<String>> nomesPorTipo = usuarios
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                Usuario::isModerador,
                                Collectors.mapping(Usuario::getNome, Collectors.toList())
                        )
                );
        System.out.println(nomesPorTipo);
        System.out.println();

        // particionar por moderação, mas ter como valor não os usuários, mas sim a soma de seus pontos
        Map<Boolean, Integer> pontuacaoPorTipo = usuarios
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                Usuario::isModerador,
                                Collectors.summingInt(Usuario::getPontos)
                        )
                );
        System.out.println(pontuacaoPorTipo);
        System.out.println();

        // Concatenar nomes de todos os usuários
        String nomes = usuarios
                .stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(nomes);
        System.out.println();

    }


    public static Stream<String> lines(Path p) {

        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilerme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 100);

        return Arrays.asList(user1, user2, user3, user4, user5);
    }

}
