package com.java8.book.casadocodigo.capitulo8.maisstreams;

import com.java8.book.casadocodigo.model.Usuario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileDemonstration {

    public static void main(String[] args) throws IOException {

        // Listar todos os arquivos de um diretório
/*        try {
            Files.list(Paths.get("./br/com/casadocodigo/java8"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        // Listar todos os arquivos de um diretório
        try {
            Files.list(Paths.get("."))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // Listar apenas arquivos java
        Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .forEach(System.out::println);


        // Ler todas as linhas de cada arquivo
        Stream<Stream<String>> strings = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .map(p -> lines(p));


        // Usando Flat para achatar um Stream
        Stream<String> strings2 = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .flatMap(p -> lines(p));

        // IntStream possui todos os caracteres de todos os arquivos  xml
        IntStream chars = Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".xml"))
                .flatMap(p -> lines(p))
                .flatMapToInt((String s) -> s.chars());

    }

    public static Stream<String> lines(Path p){

        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

