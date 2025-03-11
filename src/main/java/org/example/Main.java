package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("1. Crear producto");
            if (!productos.isEmpty()) {
                System.out.println("2. Vender producto");
                System.out.println("3. Reponer cantidad");
                System.out.println("4. Aplicar descuento 2%");
                System.out.println("5. Mostrar productos");
                System.out.println("6. Aumentar precio 6%");
                System.out.println("7. Calcular valor total del inventario");
                System.out.println("8. Eliminar producto por codigo");
            }
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!teclado.hasNextInt()) {
                System.out.print("Por favor, ingrese un numero valido: ");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion != 1 && productos.isEmpty() && opcion != 9) {
                System.out.println("Debe crear al menos un producto antes de usar esta opcion.");
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el codigo del producto: ");
                    String codigo = teclado.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = teclado.nextLine();

                    int precio;
                    do {
                        System.out.print("Ingrese el precio del producto: ");
                        while (!teclado.hasNextInt()) {
                            System.out.print("Ingrese un numero valido para el precio: ");
                            teclado.next();
                        }
                        precio = teclado.nextInt();
                        if (precio <= 0) System.out.println("El precio debe ser mayor que 0.");
                    } while (precio <= 0);

                    int cantidad;
                    do {
                        System.out.print("Ingrese la cantidad en el inventario: ");
                        while (!teclado.hasNextInt()) {
                            System.out.print("Ingrese un numero valido para la cantidad: ");
                            teclado.next();
                        }
                        cantidad = teclado.nextInt();
                        if (cantidad <= 0) System.out.println("La cantidad debe ser mayor que 0.");
                    } while (cantidad <= 0);

                    Producto obj = new Producto();
                    obj.crearProducto(codigo, nombre, precio, cantidad);
                    productos.add(obj);
                    System.out.println("Producto agregado.");
                }
                case 2 -> {
                    System.out.print("Ingrese el codigo del producto a vender: ");
                    String codigoVenta = teclado.nextLine();
                    Producto productoVenta = buscarProducto(productos, codigoVenta);

                    if (productoVenta != null) {
                        int cantidadVenta;
                        do {
                            System.out.print("Ingrese la cantidad a vender: ");
                            while (!teclado.hasNextInt()) {
                                System.out.print("Ingrese un numero valido: ");
                                teclado.next();
                            }
                            cantidadVenta = teclado.nextInt();
                            if (cantidadVenta <= 0) System.out.println("Debe ingresar una cantidad mayor a 0.");
                        } while (cantidadVenta <= 0);

                        productoVenta.venderProducto(cantidadVenta);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el codigo del producto a reponer: ");
                    String codigoReponer = teclado.nextLine();
                    Producto productoReponer = buscarProducto(productos, codigoReponer);

                    if (productoReponer != null) {
                        int cantidadReponer;
                        do {
                            System.out.print("Ingrese la cantidad a reponer: ");
                            while (!teclado.hasNextInt()) {
                                System.out.print("Ingrese un numero valido: ");
                                teclado.next();
                            }
                            cantidadReponer = teclado.nextInt();
                            if (cantidadReponer <= 0) System.out.println("Debe ingresar una cantidad mayor a 0.");
                        } while (cantidadReponer <= 0);

                        productoReponer.reponerProducto(cantidadReponer);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                }
                case 4 -> productos.forEach(Producto::descuento);
                case 5 ->{
                        System.out.println("Aun no hay inventario");

                        productos.forEach(Producto::mostrarProducto);
                }
                case 6 -> productos.forEach(Producto::aumentarPrecio);
                case 7 -> {
                    int totalInventario = 0;

                    for (Producto producto : productos) {
                        totalInventario += producto.inventario();
                    }
                    System.out.println("Valor total del inventario: $" + totalInventario);

                }
                case 8 -> {
                    System.out.print("Codigo del producto a eliminar: ");
                    String codigoEliminar = teclado.nextLine();
                    boolean eliminado = productos.removeIf(p -> p.getCodigo().equals(codigoEliminar));
                    System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
                }
                case 9 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 9);
    }

    private static Producto buscarProducto(List<Producto> productos, String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
}