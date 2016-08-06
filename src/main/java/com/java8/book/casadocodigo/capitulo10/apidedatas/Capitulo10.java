package com.java8.book.casadocodigo.capitulo10.apidedatas;

import java.time.*;

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
        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12,0);
        System.out.println(hojeAoMeioDia);


        // Unir uma classe LocalDate com LocalTime
        LocalTime agoraTime = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEhora = hoje.atTime(agoraTime);


        // Adicionar o método atZone para construir um ZonedDateTime
        ZonedDateTime dataComHoraETimezone = dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));

        // Convertendo para outras medidas de tempo
        LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();



    }
}
