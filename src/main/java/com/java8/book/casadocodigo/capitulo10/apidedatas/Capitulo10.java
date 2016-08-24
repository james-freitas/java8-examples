package com.java8.book.casadocodigo.capitulo10.apidedatas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Capitulo10 {

    public static void main(String[] args) {


        // criar uma data com um mês a partir da data atual
        LocalDate mesQueVem = LocalDate.now().plusMonths(1);

        // decrementar valores
        LocalDate anoPassado = LocalDate.now().minusYears(1);

        // Com data e horario
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);


        // Representar somente as horas
        LocalTime agoraHoras = LocalTime.now();
        System.out.println(agoraHoras);


        // Criar com horario especifico
        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);
        System.out.println(hojeAoMeioDia);


        // Unir uma classe LocalDate com LocalTime
        LocalTime agoraTime = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEhora = hoje.atTime(agoraTime);


        // Adicionar o método atZone para construir um ZonedDateTime
        ZonedDateTime dataComHoraETimezone = dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));

        // Convertendo para outras medidas de tempo
        LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();

        // construcao de outas datas
        LocalDate date = LocalDate.of(2014, 12, 25);
        LocalDateTime dateTime = LocalDateTime.of(2014, 12, 25, 10, 30);


        // Modificar o ano de um LocalDate
        LocalDate dataDoPassado = LocalDate.now().withYear(1988);

        // Para recuperar o ano de uma data
        System.out.println(dataDoPassado.getYear());

        // Saber se alguma medida de tempo acontece antes, depois ou ao mesmo tempo que outra
        LocalDate hoje3 = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);

        System.out.println(hoje3.isBefore(amanha));
        System.out.println(hoje3.isAfter(amanha));
        System.out.println(hoje3.isEqual(amanha));
        System.out.println();

        // comparar datas iguais em timezones diferentes
        System.out.println("comparar datas iguais em timezones diferentes");
        ZonedDateTime tokyo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
        System.out.println(tokyo.isEqual(saoPaulo));
        System.out.println();

        // mesmo do acima mas acertando as 12 horas de diferenca
        System.out.println("mesmo do acima mas acertando as 12 horas de diferenca");
        ZonedDateTime tokyo1 = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo1 = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
        tokyo1 = tokyo1.plusHours(12);
        System.out.println(tokyo1.isEqual(saoPaulo1));
        System.out.println();


        // obter o dia do mês atual
        System.out.println("obter o dia do mês atual");
        System.out.println("hoje é dia: " + MonthDay.now().getDayOfMonth());
        System.out.println();

        // obter o Ano/Mes de uma determinada data
        System.out.println("obter o Ano/Mes de uma determinada data");
        YearMonth ym = YearMonth.from(amanha);
        System.out.println(ym.getMonth() + " " + ym.getYear());
        System.out.println();

        // trabalhando com enums no lugar de constantes - mes
        System.out.println("trabalhando com enums no lugar de constantes - mes");
        System.out.println(LocalDate.of(2014, 12, 25));
        System.out.println(LocalDate.of(2014, Month.DECEMBER, 25));
        System.out.println();

        // consultar o primeiro dia do trimestre de determinadomês
        System.out.println("consultar o primeiro dia do trimestre de determinadomês");
        System.out.println(Month.DECEMBER.firstMonthOfQuarter());
        System.out.println(Month.DECEMBER.plus(2));
        System.out.println(Month.DECEMBER.minus(1));
        System.out.println();

        // imprimir o nome de um mês formatado
        System.out.println("imprimir o nome de um mês formatado");
        Locale pt = new Locale("pt");
        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, pt));
        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.SHORT, pt));
        System.out.println();

        // formatar em horas
        System.out.println("formatar em horas");
        LocalDateTime agora2 = LocalDateTime.now();
        String resultado = agora2.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println();

        // criar um DateTimeFormatter com um novo padrão
        System.out.println("criar um DateTimeFormatter com um novo padrão");
        LocalDateTime agora3 = LocalDateTime.now();
        agora3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println();

        // retornar o nosso resultado anterior em um LocalDate
        System.out.println("retornar o nosso resultado anterior em um LocalDate");
        LocalDateTime agora4 = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado2 = agora4.format(formatador);
        LocalDate agoraEmData = LocalDate.parse(resultado2, formatador);
        System.out.println();


        // Simulando DateException para datas inválidas
       // System.out.println("Simulando DateException para datas inválidas");
       // LocalDate.of(2014, Month.FEBRUARY, 30);

        // Simulando DateException para horas inválidas
        //System.out.println("Simulando DateException para horas inválidas");
        //LocalDate.now().atTime(25,0);

        // calcular a diferença de dias
        System.out.println("calcular a diferença de dias ");
        LocalDate agora5 = LocalDate.now();
        LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
        long dias = ChronoUnit.DAYS.between(outraData, agora);
        System.out.println();

        // saber a diferença de anos e meses entre essas duas datas
        System.out.println("saber a diferença de anos e meses entre essas duas datas");
        long dias1 = ChronoUnit.DAYS.between(outraData, agora5);
        long meses = ChronoUnit.MONTHS.between(outraData, agora5);
        long anos = ChronoUnit.YEARS.between(outraData, agora5);
        System.out.printf("%s dias, %s meses e %s anos", dias, meses, anos);
        System.out.println();
        System.out.println();

        // Obter os dias, meses e anos entre datas
        System.out.println("Obter os dias, meses e anos entre datas");
        LocalDate agora6 = LocalDate.now();
        LocalDate outraData1 = LocalDate.of(1989, Month.JANUARY, 25);
        Period periodo = Period.between(outraData1, agora6);
        System.out.printf("%s dias, %s meses e %s anos", periodo.getDays(), periodo.getMonths(), periodo.getYears());
        System.out.println();
        System.out.println();


        // Period lidando com valores negativos
        System.out.println("Period lidando com valores negativos");
        LocalDate agora7 = LocalDate.now();
        LocalDate outraData2 = LocalDate.of(2015, Month.JANUARY, 25);
        Period period = Period.between(outraData2, agora7);
        System.out.printf("%s dias, %s meses e %s anos", period.getDays(), period.getMonths(), period.getYears());
        System.out.println();
        System.out.println();


        // criar um período de horas, minutos ou segundos com Duration
        System.out.println("criar um período de horas, minutos ou segundos com Duration");
        LocalDateTime agora8 = LocalDateTime.now();
        LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
        Duration duration = Duration.between(agora8, daquiAUmaHora);

        if(duration.isNegative()){
            duration = duration.negated();
        }

        System.out.printf("%s horas, %s minutos e %s segundos", duration.toHours(), duration.toMinutes(), duration.getSeconds());
        System.out.println();
        System.out.println();





    }
}
