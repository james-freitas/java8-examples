package goodies;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentTest {

    List<Payment> payments;

    Payment payment1;
    Payment payment2;
    Payment payment3;
    Payment payment4;
    Payment payment5;

    LocalDateTime today;
    LocalDateTime yesterday;
    LocalDateTime lastMonth;

    @Before
    public void setUp() throws Exception {
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilherme Silveira");
        Customer adriano = new Customer("Adriano Almeida");

        Product bach = new Product("Bach Completo",
                Paths.get("/music/bach.mp3"), new BigDecimal(100));
        Product poderosas = new Product("Poderosas Anita",
                Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
        Product bandeira = new Product("Bandeira Brasil",
                Paths.get("/images/brasil.jpg"), new BigDecimal(50));
        Product beauty = new Product("Beleza Americana",
                Paths.get("beauty.mov"), new BigDecimal(150));
        Product vingadores = new Product("Os Vingadores",
                Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
        Product amelie = new Product("Amelie Poulain",
                Paths.get("/movies/amelie.mov"), new BigDecimal(100));

        today = LocalDateTime.now();
        yesterday = today.minusDays(1);
        lastMonth = today.minusMonths(1);

        payment1 = new Payment( Arrays.asList(bach, poderosas), today, paulo);
        payment2 = new Payment( Arrays.asList(bach, bandeira, amelie), yesterday, rodrigo);
        payment3 = new Payment( Arrays.asList(beauty, vingadores, bach), today, adriano);
        payment4 = new Payment(Arrays.asList(bach, poderosas, amelie), lastMonth, guilherme);
        payment5 = new Payment(Arrays.asList(beauty, amelie), yesterday, paulo);

        payments = Arrays.asList(payment1, payment2, payment3, payment4, payment5);
    }


    @Test
    public void testImprimirPagamentosEmOrdem()  {
        System.out.println();
        payments.stream()
                .sorted(Comparator.comparing(Payment::getDate))
                .forEach(System.out::println);

        List<Payment> resultList = payments.stream()
                .sorted(Comparator.comparing(Payment::getDate))
                .collect(Collectors.toList());

        assertThat(resultList.get(0).getDate().toLocalDate(), is(lastMonth.toLocalDate()));
        assertThat(resultList.get(0).getCustomer().getName(), equalTo("Guilherme Silveira"));

        assertThat(resultList.get(1).getDate().toLocalDate(), is(yesterday.toLocalDate()));
        assertThat(resultList.get(1).getCustomer().getName(), equalTo("Rodrigo Turini"));

        assertThat(resultList.get(2).getDate().toLocalDate(), is(yesterday.toLocalDate()));
        assertThat(resultList.get(2).getCustomer().getName(), equalTo("Paulo Silveira"));

    }

    @Test
    public void testImprimeSomaProdutosPagamento1() throws Exception {
        System.out.println();
        payment1.getProducts().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .ifPresent(System.out::println);

        BigDecimal totalPayment1 = payment1.getProducts().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(totalPayment1, equalTo(BigDecimal.valueOf(190)));
    }

    @Test
    public void testSomaTodosOsPagamentos() throws Exception {

        BigDecimal totalFlat = payments.stream()
                .flatMap(p -> p.getProducts().stream().map(Product::getPrice))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(totalFlat, equalTo(BigDecimal.valueOf(1430)));

    }

    @Test
    public void testProdutosMaisVendidos() throws Exception {

        Map<Product,Long> topProducts = payments.stream()
                .flatMap(p -> p.getProducts().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

/*
        topProducts.entrySet().stream()
                .forEach(System.out::println);
*/

        topProducts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);

        Optional<Map.Entry<Product,Long>> max = topProducts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        assertThat( max.get().getValue(), is(equalTo(4L)));
        assertThat( max.get().getKey().getName(), is(equalTo("Bach Completo")));
    }


    @Test
    public void testSomaDoValorPorProduto() throws Exception {
        Map<Product, BigDecimal> totalValuePerProduct = payments.stream()
                .flatMap(p -> p.getProducts().stream())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)));

        totalValuePerProduct.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);

        Product productBandeira = new Product("Bandeira Brasil",
                Paths.get("/images/brasil.jpg"), new BigDecimal(50));

        assertThat(totalValuePerProduct.get(productBandeira), is(equalTo(new BigDecimal(50))));

    }
}
