package Ejercicio_Practico.Inventario.JAVA;
import Ejercicio_Practico.Inventario.JAVA.Library.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Producto> inventario = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String claveAdmin;

    public static void main(String[] args) {
        // Registro inicial de la contraseña del administrador
        System.out.println("=== CONFIGURACIÓN INICIAL ===");
        System.out.print("Cree la contraseña del administrador: ");
        claveAdmin = sc.nextLine();

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar stock");
            System.out.println("3. Listar productos con bajo stock");
            System.out.println("4. Buscar producto");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    if (verificarAcceso()) {
                        agregarProducto();
                    } else {
                        System.out.println("Acceso denegado.");
                    }
                    break;
                case 2:
                    if (verificarAcceso()) {
                        actualizarStock();
                    } else {
                        System.out.println("Acceso denegado.");
                    }
                    break;
                case 3:
                    listarBajoStock();
                    break;
                case 4:
                    buscarProducto();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    public static boolean verificarAcceso() {
        System.out.print("Ingrese la contraseña de administrador: ");
        String intento = sc.nextLine();
        return intento.equals(claveAdmin);
    }

    public static void agregarProducto() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        if (codigoExiste(codigo)) {
            System.out.println("Error: Código repetido.");
            return;
        }

        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();

        System.out.print("Categoría (opcional): ");
        String categoria = sc.nextLine();

        if (nombre.isEmpty() || codigo.isEmpty() || precio <= 0) {
            System.out.println("Error: Datos inválidos o incompletos.");
            return;
        }

        Producto nuevo = new Producto(nombre, codigo, precio, categoria);
        inventario.add(nuevo);
        System.out.println("Producto registrado correctamente.");
    }

    public static void actualizarStock() {
        System.out.println("\n--- ACTUALIZAR STOCK ---");
        System.out.print("Código del producto: ");
        String codigo = sc.nextLine();

        Producto prod = buscarPorCodigo(codigo);
        if (prod == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Cantidad (positiva): ");
        int cantidad = sc.nextInt(); sc.nextLine();

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }

        System.out.print("Estado (Ingreso/Egreso): ");
        String estado = sc.nextLine().toLowerCase();

        if (estado.equals("ingreso")) {
            prod.stock += cantidad;
            System.out.println("Stock actualizado. Nuevo stock: " + prod.stock);
        } else if (estado.equals("egreso")) {
            if (prod.stock < cantidad) {
                System.out.println("Error: Stock insuficiente.");
            } else {
                prod.stock -= cantidad;
                System.out.println("Stock actualizado. Nuevo stock: " + prod.stock);
            }
        } else {
            System.out.println("Estado no válido. Use 'Ingreso' o 'Egreso'.");
        }
    }

    public static void listarBajoStock() {
        System.out.println("\n--- PRODUCTOS CON BAJO STOCK ---");
        System.out.print("Ingrese el nivel mínimo de stock: ");
        int minimo = sc.nextInt(); sc.nextLine();

        boolean hayResultados = false;
        for (Producto p : inventario) {
            if (p.stock < minimo) {
                System.out.println(p);
                hayResultados = true;
            }
        }

        if (!hayResultados) {
            System.out.println("No hay productos con stock bajo.");
        }
    }

    public static void buscarProducto() {
        System.out.println("\n--- BÚSQUEDA DE PRODUCTO ---");
        System.out.print("Nombre (puede estar vacío): ");
        String nombre = sc.nextLine().toLowerCase();
        System.out.print("Código (puede estar vacío): ");
        String codigo = sc.nextLine();
        System.out.print("Categoría (opcional): ");
        String categoria = sc.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Producto p : inventario) {
            if (
                (!nombre.isEmpty() && p.nombre.toLowerCase().contains(nombre)) ||
                (!codigo.isEmpty() && p.codigo.equals(codigo)) ||
                (!categoria.isEmpty() && p.categoria.toLowerCase().contains(categoria))
            ) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún producto.");
        }
    }

    public static boolean codigoExiste(String codigo) {
        for (Producto p : inventario) {
            if (p.codigo.equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public static Producto buscarPorCodigo(String codigo) {
        for (Producto p : inventario) {
            if (p.codigo.equals(codigo)) {
                return p;
            }
        }
        return null;
    }
}