package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RuletaRusa {
    private List<Integer> tambor;
    public int bala;
    private int posicionActual;
    private Random random;

    public RuletaRusa() {
        random = new Random();
        reiniciarJuego();
    }

    public void reiniciarJuego() {
        tambor = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }
        do {
            bala = random.nextInt(6);
        } while (bala == 0);
        posicionActual = 0; // Siempre empieza en la posición 0
    }

    public boolean disparar() {
        posicionActual = (posicionActual + 1) % 6; // Avanza antes de disparar
        boolean resultado = posicionActual == bala;
        return resultado;
    }
}