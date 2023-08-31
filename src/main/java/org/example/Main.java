package org.example;
import org.example.RelogioTdd;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RelogioTdd relogioMain = new RelogioTdd(22, 46, 34);

        relogioMain.imprimir();

        relogioMain.iniciarCronometro();
        try {
            Thread.sleep(2000); // Espera por 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Tempo decorrido: " + relogioMain.tempoDecorridoCronometro() + " ms");
        relogioMain.pararCronometro();


    }
}