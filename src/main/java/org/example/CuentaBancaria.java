package org.example;

import java.sql.SQLOutput;

public class CuentaBancaria  {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }


    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }

    public void depositarDinero(double cantidad) {
        System.out.println("Cuanto quiere depositar: ");
        if (!validarNegativo((int) cantidad)) {
            return;
        }
        this.saldo += cantidad;
        System.out.println("Deposito realizado con exito saldo: $" + saldo);
    }

    public void retirarDinero(double cantidad){
        if (!validarNegativo((int) cantidad)) {
            return;
        }if (cantidad > saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= cantidad;
        System.out.println("Retiro realizado con exito saldo: $" + saldo);
    }
    public boolean validarNegativo(int cantidad){
        if (cantidad < 0){
            System.out.println("La cantidad no puede ser menor a $0");
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "saldoCuenta=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                '}';
    }

}