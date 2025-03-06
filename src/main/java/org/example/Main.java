package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        int opcion = 0, opcion2 = 0, opcion3 = 0, candidato = 0;
        int votosTotal = 0, votosCandidato1 = 0, votosCandidato2 = 0, votosCandidato3 = 0;
        int costoCandidato1 = 0, costoCandidato2 = 0, costoCandidato3 = 0;
        int internet = 700000, radio = 200000, television = 600000;
        double operacion1, operacion2, operacion3;
        int promedioCampaña = 0, totalCostoCandidatos = 0;

        do {
            System.out.println("**Bienvenido a las votaciones para el proximo representante de Premier **");
            System.out.println("1. Votar por un candidato");
            System.out.println("2. Ver el costo total de campaña");
            System.out.println("3. Vaciar las urnas");
            System.out.println("4. Mostrar total de votos y porcentaje por candidato");
            System.out.println("5. Porcentaje por candidato");
            System.out.println("6. Mostrar costo promedio de campaña");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione su candidato: ");
                    System.out.println("1. Jose Papayuela** ");
                    System.out.println("2. Pedro Picapiedra** ");
                    System.out.println("3. Ricardo Arjona** ");
                    candidato = entrada.nextInt();

                    if (candidato < 1 || candidato > 3) {
                        System.out.println("Candidato no valido");
                        break;
                    }
                    System.out.println("**Cuantos medios de promocion influyeron en su voto **");
                    System.out.println("1. Unos medio");
                    System.out.println("2. Dos medios");
                    System.out.println("3. Tres medios");
                    opcion2 = entrada.nextInt();

                    int costoVoto = 0;

                    for (int i = 0; i< opcion2;i++) {

                        System.out.println("Seleccione el medio:");
                        System.out.println("1. Internet");
                        System.out.println("2. Radio");
                        System.out.println("3. Television");

                        opcion3 = entrada.nextInt();

                        switch (opcion3) {
                            case 1:
                                costoVoto += internet;
                                break;
                            case 2:
                                costoVoto += radio;
                                break;
                            case 3:
                                costoVoto += television;
                                break;
                            default:
                                System.out.println("Medio no valido");
                                i--;
                                break;
                        }
                    }votosTotal++;

                    if (candidato == 1) {
                        votosCandidato1++;
                        costoCandidato1 += costoVoto;
                    } else if (candidato == 2) {
                        votosCandidato2++;
                        costoCandidato2 += costoVoto;
                    } else {
                        votosCandidato3++;
                        costoCandidato3 += costoVoto;
                    }

                    System.out.println("Voto registrado con exito....");
                    break;

                case 2:
                    System.out.println("**Costos campaña **");
                    System.out.println("Jose Papayuela: $" + costoCandidato1);
                    System.out.println("Pedro Picapiedra: $" + costoCandidato2);
                    System.out.println("Ricardo Arjona: $" + costoCandidato3);
                    break;

                case 3:
                    System.out.println("Vaciando urnas...");
                    System.out.println("Alguien enveneno el abrevadero...");

                    votosTotal = votosCandidato1 = 0;
                    votosTotal = votosCandidato2 = 0;
                    votosTotal = votosCandidato3 = 0;
                    costoCandidato1 = 0;
                    costoCandidato2 = 0;
                    costoCandidato3 = 0;

                    break;
                case 4:
                    if (votosTotal == 0) {
                        System.out.println("No hay votos registrados");
                    } else {
                        System.out.println("**Resultados de votacion **");
                    }
                    break;
                case 5:
                    if (votosTotal == 0) {
                        System.out.println("No hay votos registrados");
                    } else {
                        System.out.println("**Resultados de votacion **");
                        operacion1 = votosCandidato1 * 100 / votosTotal;
                        operacion2 = votosCandidato2 * 100 / votosTotal;
                        operacion3 = votosCandidato3 * 100 / votosTotal;

                        System.out.println("Jose Papayuela:  " + operacion1 + "%");
                        System.out.println("Pedro Picapiedra:  " + operacion2 + "%");
                        System.out.println("Ricardo Arjona:  " + operacion3 + "%");

                    }
                    break;

                case 6:
                    if (votosTotal == 0) {
                        System.out.println("No hay votos");
                    } else {
                        totalCostoCandidatos = costoCandidato1 + costoCandidato2 + costoCandidato3;
                        promedioCampaña = totalCostoCandidatos * 100 / votosTotal;
                        System.out.println("El promedio de las camapañas es de: " + decimalFormat.format(promedioCampaña));
                    }
                    break;

                case 7:
                    System.out.println("Gracias por participar en las elecciones");
                    break;

                default:
                    System.out.println("Opcion no valida >:c");
                    break;
            }
        } while (opcion != 7);
    }
}
