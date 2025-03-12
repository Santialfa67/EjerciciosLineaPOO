package org.example;

import java.util.List;
import java.util.Random;

public class cabinaTelefonica {
    private int cabina;
    private int llamadasLocales;
    private int llamadasLargaDistancia;
    private int llamadasCelular;
    private int minLocales;
    private int minLargaDistancia;
    private int minCelular;
    private int costoLocal =50;
    private int costoLargaDistancia = 350;
    private int costoCelular = 150;


    Random llamadaNumero = new Random();


    public cabinaTelefonica(int cabina) {
        this.llamadasLocales = 0;
        this.llamadasLargaDistancia = 0;
        this.llamadasCelular = 0;
        this.minLocales = 0;
        this.minLargaDistancia = 0;
        this.minCelular = 0;
        this.cabina = cabina;
    }
    public void registarLlamada (int tipo) {
        Random random = new Random();
        int minutos = random.nextInt(60) + 1;

        switch (tipo){
            case 1 ->{
                llamadasLocales++;
                minLocales += minutos;
            }
            case 2->{
                llamadasCelular++;
                minCelular += minutos;
            }
            case 3 ->{
                llamadasLargaDistancia++;
                minLargaDistancia += minutos;
            }
            default -> {
                System.out.println("Dijite un tipo valido");
                return;
            }
        }
        System.out.println("Registrando....");
    }
    public int calcularCostoTotal(){
        return ((minLocales * costoLocal) + (minLargaDistancia * costoLargaDistancia) +(minCelular * costoCelular));
    }
    public void mostrarInformacion() {
        int costoTotal = calcularCostoTotal();
        System.out.println("Cabina: " + cabina);
        System.out.println("Llamadas Locales: " + llamadasLocales + " Minutos: " + minLocales + " Costo: $" + (minLocales * costoLocal));
        System.out.println("Llamadas Larga Distancia: " + llamadasLargaDistancia + " Minutos: " + minLargaDistancia + " Costo: $" + (minLargaDistancia * costoLargaDistancia));
        System.out.println("Llamadas a Celular: " + llamadasCelular + " Minutos: " + minCelular + " Costo: $" + (minCelular * costoCelular));
        System.out.println("Costo Total: $" + costoTotal);
    }
    public int calcularLlamadasTotales(){
        return (llamadasCelular + llamadasLocales + llamadasLargaDistancia);
    }
    public int calcularMinutosTotales(){
        return (minLocales + minLargaDistancia + minCelular);
    }


    public void reiniciarCabina() {
        llamadasLocales = 0;
        llamadasLargaDistancia = 0;
        llamadasCelular = 0;
        minLocales = 0;
        minLargaDistancia = 0;
        minCelular = 0;
        System.out.println("Cabina: " + cabina + " Vacia.....");
    }

    public static cabinaTelefonica buscarCabinaTelefonica(List<cabinaTelefonica> cabinas, int id) { //Metodo estatico para no necesitar un objeto previo
        for (cabinaTelefonica cabina : cabinas) {
            if (cabina.getCabina() == id) {
                return cabina;
            }
        }
        return null;
    }

    private int getCabina() {
        return cabina;
    }


}
