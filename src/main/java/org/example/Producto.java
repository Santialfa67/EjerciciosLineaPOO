package org.example;

import java.util.List;

public class Producto {
    private String nombre;
    private String codigo;
    private int precio;
    private int cantidad;

    public Producto() {
    }

    public void crearProducto(String codigo, String nombre, int precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean venderProducto(int pedido) {
        if (pedido <= 0) {
            System.out.println("Cantidad invalida debe ser mayor que 0.");
            return false;
        }
        if (pedido > cantidad) {
            System.out.println("No hay suficiente  disponible.");
            return false;
        }
        cantidad -= pedido;
        System.out.println("Venta exitosa: " + pedido + " unidades vendidas.");
        return true;
    }

    public void reponerProducto(int pedido) {
        if (pedido <= 0) {
            System.out.println("Cantidad invalida debe ser mayor que 0.");
            return;
        }
        cantidad += pedido;
        System.out.println("Unidades totales: " + cantidad);
    }

    public void descuento() {
        precio -= precio * 0.02;
        System.out.println("precio: $" + precio);
    }

    public void aumentarPrecio() {
        precio += precio * 0.06;
        System.out.println("precio: $" + precio);
    }

    public void mostrarProducto() {
        System.out.println("Codigo: " + codigo + "  Nombre: " + nombre + "  Precio: $" + precio + "  Stock: " + cantidad);
    }

    public int inventario() {
        int totalInventario = cantidad * precio;
        return totalInventario;
    }
    public static Producto buscarProducto(List<Producto> productos, String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
}
