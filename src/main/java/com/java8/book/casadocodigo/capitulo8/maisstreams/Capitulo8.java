package com.java8.book.casadocodigo.capitulo8.maisstreams;

import com.java8.book.casadocodigo.model.Usuario;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo8 {

    public static void main(String[] args) {

        List<Usuario> usuarios = getUsuarios();
        usuarios.forEach(Usuario::tornaModerador);

        // Ordenando
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());

        // Usando métodos lazy
        Optional<Usuario> usuarioOptional = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .findAny();

        // Enxergando a execução do pipeline com peek ao pegar um
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .peek(System.out::println)
                .findAny();

        System.out.println("---------------");

        // Enxergando a execução do pipeline com peek ao ordenar
        usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println)
                .findAny();
        System.out.println("---------------");
        // Operaçoes de redução
        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        // Max
        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparing(Usuario::getPontos));
        Usuario maximaPontuacao = max.get();

        // Sum
        int total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();

        // multiplicar os pontos
        int multiplicacao = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(1, (a, b) -> a * b);

        // soma sem map
        int total2 = usuarios.stream()
                .reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);


        // usando iterator no stream
        usuarios.stream().iterator()
                .forEachRemaining(System.out::println);

        // saber se algum usuario é moderador
        boolean hasModerator = usuarios.stream()
                .anyMatch(Usuario::isModerador);

        // outros allMatch e noneMatch


        // gerando lista infinita de numeros aleatórios
        Random random = new Random(0);
        Supplier<Integer> supplier = () -> random.nextInt();
        Stream<Integer> stream = Stream.generate(supplier);


        // pegar 100 primeiros
        Random random1 = new Random(0);
        IntStream stream1 = IntStream.generate(() -> random.nextInt());


/*        List<Integer> list = stream
                .limit(100)
                .boxed()
                .collect(Collectors.toList());*/

        Random random2 = new Random(0);
        List<Integer> list = IntStream
                .generate(() -> random2.nextInt())
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        // Gerando a sequencia de Fibonacci e imprimir seus 10 primeiros elementos



        // gerar numeros naturais
        IntStream.iterate(0, x -> x + 1)
                .limit(10)
                .forEach(System.out::println);



    }

    private static List<Usuario> getUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilerme Silveira", 100);
        Usuario user4 = new Usuario("James", 110);

        return Arrays.asList(user1, user2, user3, user4);
    }
}

class Fibonacci implements IntSupplier {
    private int anterior = 0;
    private int proximo = 1;


    @Override
    public int getAsInt() {
        proximo = proximo + anterior;
        anterior = proximo - anterior;
        return anterior;
    }

    public static void main(String[] args) {
        IntStream.generate(new Fibonacci())
                .limit(10)
                .forEach(System.out::println);

        OptionalInt maioQue100 = IntStream
                .generate(new Fibonacci())
                .filter(f -> f > 100)
                .findFirst();

        System.out.println(maioQue100);
    }
}
