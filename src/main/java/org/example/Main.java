package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        List<CuentaBancaria> cuentas = new ArrayList<>();

        CuentaBancaria cuenta1 = new CuentaBancaria("Santiago", "1000000", 100.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Papayo", "110000",  10.0);
        CuentaBancaria cuenta3 =new CuentaBancaria();

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);

        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());


        cuenta3.setTitular("Aurelio Cheveroni");
        cuenta3.setNumeroCuenta("1110000");
        cuenta3.setSaldo(50.0);

        System.out.println(cuenta3);

        do {
            System.out.println("1. Ver cuentas disponibles");
            System.out.println("2. Acceder a una cuenta");
            System.out.println("3. Crear una cuenta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Cuentas Disponibles");
                    for (CuentaBancaria cuenta : cuentas) {
                        System.out.println("Titular: " + cuenta.getTitular() + " Numero de Cuenta: " + cuenta.getNumeroCuenta() +
                                " Saldo: " + cuenta.getSaldo());
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese su numero de cuenta: ");
                    String numeroIngresado = teclado.nextLine();

                    CuentaBancaria cuentaSeleccionada = buscarCuentaPorNumero(cuentas, numeroIngresado);
                    if (cuentaSeleccionada != null) {
                        System.out.println("Acceso permitido " + cuentaSeleccionada.getTitular());
                        int opcionCuenta;
                        do {
                            System.out.println("Operaciones para " + cuentaSeleccionada.getTitular() + " ");
                            System.out.println("1. Depositar dinero");
                            System.out.println("2. Retirar dinero");
                            System.out.println("3. Menu principal");
                            System.out.print("Seleccione una opcion: ");
                            opcionCuenta = teclado.nextInt();

                            switch (opcionCuenta) {
                                case 1 -> {
                                    System.out.print("Ingrese cantidad: ");
                                    double cantidad = teclado.nextDouble();
                                    cuentaSeleccionada.depositarDinero(cantidad);
                                }
                                case 2 -> {
                                    System.out.print("Ingrese cantidad: ");
                                    double cantidad = teclado.nextDouble();
                                    cuentaSeleccionada.retirarDinero(cantidad);
                                }
                            }
                        } while (opcionCuenta != 3);
                    } else {
                        System.out.println("Numero de cuenta invalido.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del titular: ");
                    String titular = teclado.nextLine();

                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = teclado.nextLine();

                    System.out.print("Ingrese el saldo inicial: ");
                    double saldo = teclado.nextDouble();

                    CuentaBancaria nuevaCuenta = new CuentaBancaria(titular, numeroCuenta, saldo);
                    cuentas.add(nuevaCuenta);
                    System.out.println("Cuenta creada con exito.");
                }
                case 4 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 4);

    }

    private static CuentaBancaria buscarCuentaPorNumero(List<CuentaBancaria> cuentas, String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}