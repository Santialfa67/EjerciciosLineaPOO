package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);

        int opcion = 0, valor = 0, alcancia = 0;


        do {

            System.out.println("**Menu de opciones** ");
            System.out.println("1. Para insertar una moneda a la alcancia** ");
            System.out.println("2. Para ver Cuanto hay en la alcancia** ");
            System.out.println("3. Vaciar alcancia** ");
            System.out.println("3. Para romper la alcancia** ");
            System.out.println("Digite una opcion: ");


            opcion = entrada.nextInt();
            switch (opcion) {

                case 1:
                    int moneda = 0;
                    System.out.print("Que moneda vas a insertar? Recuerda solo de 20 50 100 200 y 500: ");
                    moneda = entrada.nextInt();
                    if (moneda == 20 || moneda == 50 || moneda == 100 || moneda == 200 || moneda == 500) {
                        System.out.println("Moneda que vas a insertar $" + moneda);
                        valor += moneda;
                    } else {
                        System.out.println("Solo monedas de $20 $50 $100 $200 y $500");
                    }
                    break;
                case 2:
                    System.out.println("En la alcancia hay: " + valor);
                    break;
                case 3:
                    System.out.println("Vaciar alcancia");
                    valor = 0;
                    break;
                case 4:
                    System.out.println("Crack::::::: ALCANCIA ROTA :c");
                    valor = 0;
                    break;
                default:
                    System.out.print("Digite una opcion valida ");
                    break;

            }
            System.out.println("Alcancia con $" + valor);
        } while (opcion != 4);
    }
}