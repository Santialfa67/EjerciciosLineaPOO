package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<cabinaTelefonica> cabinas = new ArrayList<>();
        int opcion = 0;
        do {
            System.out.println("1. Crear cabina telefonica");
            if (!cabinas.isEmpty()) { //pregunta si el objeto no esta vacio
                System.out.println("2. Registrar una llamada");
                System.out.println("3. Mostrar informacion de una cabina");
                System.out.println("4. Mostrar consolidado de todas las cabinas");
                System.out.println("5. Reiniciar una cabina");
            }
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            while (!teclado.hasNextInt()) {
                System.out.print("Numero invalido: ");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (cabinas.isEmpty() && opcion != 1 && opcion != 6) {
                System.out.println("Debe crear al menos una cabina antes de usar esta opcion.");
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    int cabina = cabinas.size() + 1; //Trae la cantidad que hay en la lista en enteros
                    cabinas.add(new cabinaTelefonica(cabina));
                    System.out.println("ID de Cabina: " + cabina);
                }
                case 2 -> {
                    System.out.print("Ingrese el ID de la cabina: ");
                    int id = teclado.nextInt();
                    cabinaTelefonica cabina = cabinaTelefonica.buscarCabinaTelefonica(cabinas, id);
                    if (cabina != null) {
                        System.out.println("1. Local");
                        System.out.println("2. Larga Distancia");
                        System.out.println("3. Celular");
                        System.out.print("Seleccione el tipo de llamada: ");
                        int tipo = teclado.nextInt();
                        cabina.registarLlamada(tipo);
                    } else {
                        System.out.println("Cabina no encontrada");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el ID de la cabina: ");
                    int id = teclado.nextInt();
                    cabinaTelefonica cabina = cabinaTelefonica.buscarCabinaTelefonica(cabinas, id);
                    if (cabina != null) {
                        cabina.mostrarInformacion();
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                }
                case 4 -> {
                    int totalCosto = 0, totalLlamadas = 0, totalMinutos = 0;
                    int totalMinLocales = 0, totalMinLargaDistancia = 0, totalMinCelular = 0;

                    for (cabinaTelefonica cabina : cabinas) {
                        totalCosto += cabina.calcularCostoTotal();
                        totalLlamadas += cabina.calcularLlamadasTotales();
                        totalMinutos += cabina.calcularMinutosTotales();
                        totalMinLocales += cabina.getMinLocales();
                        totalMinLargaDistancia += cabina.getMinLargaDistancia();
                        totalMinCelular += cabina.getMinCelular();
                    }

                    System.out.println("Consolidado de todas las cabinas:");
                    System.out.println("Total Llamadas: " + totalLlamadas);
                    System.out.println("Total Minutos: " + totalMinutos);
                    System.out.println("Minutos Locales: " + totalMinLocales);
                    System.out.println("Minutos Larga Distancia: " + totalMinLargaDistancia);
                    System.out.println("Minutos a Celular: " + totalMinCelular);
                    System.out.println("Costo Total: $" + totalCosto);
                }
                case 5 -> {
                    System.out.print("Ingrese el ID de la cabina: ");
                    int id = teclado.nextInt();
                    cabinaTelefonica cabina = cabinaTelefonica.buscarCabinaTelefonica(cabinas, id);
                    if (cabina != null) {
                        cabina.reiniciarCabina();
                    } else {
                        System.out.println("Cabina no encontrada.....");
                    }
                }
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }
}
