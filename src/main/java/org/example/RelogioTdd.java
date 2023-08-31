package org.example;
import java.time.LocalTime;
public class RelogioTdd {

    //Variáveis
    private int hora;
    private int minuto;
    private int segundo;
    private long iniciar;
    private boolean emExecucao = false;

    //Cosnstrutor
    public RelogioTdd(){
    }
    public RelogioTdd(int hora, int minuto, int segundo){
        if(necessarioFormatar(hora, minuto, segundo)){
            this.formatarHorario();
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    //Métodos
    public boolean necessarioFormatar(int hora, int minuto, int segundo){
        return hora >= 24 || minuto >= 60 || segundo >= 60;
    }

    public void formatarHorario(){
        int hora = this.hora;
        int minuto = this.minuto;
        int segundo = this.segundo;

        // Ajusta a hora, se for maior que 23, para um valor válido
        while (hora >= 24) {
            hora -= 24;
        }

        // Ajusta o minuto, se for maior que 59, para um valor válido
        while (minuto >= 60) {
            minuto -= 60;
            hora++;
        }

        // Ajusta o segundo, se for maior que 59, para um valor válido
        while (segundo >= 60) {
            segundo -= 60;
            minuto++;
        }

        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public void reiniciarRelogio(){
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public void sincSistemaOperacional(){
        this.hora = LocalTime.now().getHour();
        this.minuto = LocalTime.now().getMinute();
        this.segundo = LocalTime.now().getSecond();
    }

    public void iniciarCronometro() {
        if (!emExecucao) {
            iniciar = System.currentTimeMillis();
            emExecucao = true;
        }
    }

    public void pararCronometro() {
        if (emExecucao) {
            emExecucao = false;
        }
    }

    public long tempoDecorridoCronometro() {
        if (emExecucao) {
            return System.currentTimeMillis() - iniciar;
        } else {
            return 0;
        }
    }

    public void reiniciarCronometro() {
        iniciar = 0;
        emExecucao = false;
    }

    public void imprimir(){
        System.out.printf("%02d:%02d:%02d\n", this.hora, this.minuto, this.segundo);
    }

    //Getters e Setters
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public long getIniciar() {
        return iniciar;
    }

    public void setIniciar(long iniciar) {
        this.iniciar = iniciar;
    }

    public boolean isEmExecucao() {
        return emExecucao;
    }

    public void setEmExecucao(boolean emExecucao) {
        this.emExecucao = emExecucao;
    }
}

