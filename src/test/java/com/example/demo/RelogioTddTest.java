package com.example.demo;

import org.example.RelogioTdd;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RelogioTddTest {
    private RelogioTdd relogioTeste = new RelogioTdd();

    @Test
    public void testeNecessarioFormatar24_Sim() {
        assertTrue(relogioTeste.necessarioFormatar(27, 33, 76));
    }

    @Test
    public void testeNecessarioFormatar24_Nao() {
        assertFalse(relogioTeste.necessarioFormatar(15, 17, 34));
    }

    @Test
    public void testeFormatarHorario() {
        relogioTeste.setHora(25);
        relogioTeste.setMinuto(62);
        relogioTeste.setSegundo(75);
        relogioTeste.formatarHorario();
        assertEquals(2, relogioTeste.getHora());
        assertEquals(3, relogioTeste.getMinuto());
        assertEquals(15, relogioTeste.getSegundo());
    }

    @Test
    public void testeReiniciarHorario() {
        relogioTeste.setHora(15);
        relogioTeste.setMinuto(2);
        relogioTeste.setSegundo(57);
        relogioTeste.reiniciarRelogio();
        assertEquals(0, relogioTeste.getHora());
        assertEquals(0, relogioTeste.getMinuto());
        assertEquals(0, relogioTeste.getSegundo());
    }

    public void testeSincSistemaOperacional() {
        relogioTeste.sincSistemaOperacional();
        assertEquals(relogioTeste.getHora(), LocalTime.now().getHour());
        assertEquals(relogioTeste.getMinuto(), LocalTime.now().getMinute());
        assertEquals(relogioTeste.getSegundo(), LocalTime.now().getSecond());
    }



}

