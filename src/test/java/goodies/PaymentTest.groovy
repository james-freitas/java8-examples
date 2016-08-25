package goodies

import spock.lang.Specification

import java.nio.file.Paths
import java.time.LocalDateTime

class PaymentTest extends Specification {

    void setup() {
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

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime lastMonth = today.minusMonths(1);

        Payment payment1 = new Payment( Arrays.asList(bach, poderosas), today, paulo);
        Payment payment2 = new Payment( Arrays.asList(bach, bandeira, amelie), yesterday, rodrigo);
        Payment payment3 = new Payment( Arrays.asList(beauty, vingadores, bach), today, adriano);
        Payment payment4 = new Payment(Arrays.asList(bach, poderosas, amelie), lastMonth, guilherme);
        Payment payment5 = new Payment(Arrays.asList(beauty, amelie), yesterday, paulo);

        List<Payment> payments = Arrays.asList(payment1, payment2, payment3, payment4, payment5);

    }
}
