package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean jugar = true;

        while (jugar) {
            RuletaRusa juego = new RuletaRusa();
            List<String> jugadores = new ArrayList<>();

            System.out.println(".....::::::::RULETA RUSA::::::........");
            System.out.print("Ingrese el numero de jugadores: ");
            int numJugadores = teclado.nextInt();
            teclado.nextLine();

            for (int i = 1; i <= numJugadores; i++) {
                System.out.print("Ingrese el nombre del jugador " + i + ": ");
                jugadores.add(teclado.nextLine());
            }

            System.out.println("La bala está en la posicion: " + juego.bala);
            int turno = new Random().nextInt(numJugadores);
            System.out.println("El jugador que empieza es: " + jugadores.get(turno));

            boolean rondaActiva = true;

            while (rondaActiva) {
                String jugadorActual = jugadores.get(turno);
                System.out.println("Turno de " + jugadorActual);
                System.out.println("Presiona enter para disparar");
                String input = teclado.nextLine();


                if (juego.disparar()) {
                    System.out.println("....:::::::SONIDO DE DISPARO:::::......");
                    System.out.println("El jugador " + jugadorActual + " MURIO");
                    rondaActiva = false;
                } else {
                    System.out.println("......::::::CLACK CLACK:::::.......");
                    System.out.println("El jugador " + jugadorActual + " Se salvo");
                    turno = (turno + 1) % numJugadores;
                }
            }
        }
        teclado.close();
    }
}
