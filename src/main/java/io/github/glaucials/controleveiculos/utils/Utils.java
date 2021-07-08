package io.github.glaucials.controleveiculos.utils;

import io.github.glaucials.controleveiculos.dto.VeiculoDTO;

import java.util.*;

public class Utils {

    public static Map<Character, String> diaRodizio = new HashMap<>();

    static {
        diaRodizio.put('0', "segunda-feira");
        diaRodizio.put('1', "segunda-feira");
        diaRodizio.put('2', "terça-feira");
        diaRodizio.put('3', "terça-feira");
        diaRodizio.put('4', "quarta-feira");
        diaRodizio.put('5', "quarta-feira");
        diaRodizio.put('6', "quinta-feira");
        diaRodizio.put('7', "quinta-feira");
        diaRodizio.put('8', "sexta-feira");
        diaRodizio.put('9', "sexta-feira");
    }

    public static void verificaRodizioAtivo(VeiculoDTO veiculoDTO) {
        String diaSemanaHoje = "";
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 2:
                diaSemanaHoje = "segunda-feira";
                break;
            case 3:
                diaSemanaHoje = "terça-feira";
                break;
            case 4:
                diaSemanaHoje = "quarta-feira";
                break;
            case 5:
                diaSemanaHoje = "quinta-feira";
                break;
            case 6:
                diaSemanaHoje = "sexta-feira";
        }

        if (veiculoDTO.getDiaRodizio().equals(diaSemanaHoje)) {
            veiculoDTO.setRodizioAtivo(Boolean.TRUE);
        } else {
            veiculoDTO.setRodizioAtivo(Boolean.FALSE);
        }

    }

}
