
import java.util.ArrayList;
import java.util.Scanner;

public class Go {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> usuarios = new ArrayList<>();
    static User usuarioActual = null;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println(" MENÚ ");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Gestionar perfil (cambiar nombre y apellido)");
            System.out.println("4. Ver historial de cambios");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    gestionarPerfil();
                    break;
                case 4:
                    verHistorial();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    public static void registrarUsuario() {
        System.out.println("\n--- REGISTRO DE USUARIO ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        User nuevo = new User(nombre, apellido, correo, contraseña);
        usuarios.add(nuevo);
        System.out.println("Usuario registrado correctamente.");
    }

    public static void iniciarSesion() {
        System.out.println("\n--- INICIAR SESIÓN ---");
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        for (User u : usuarios) {
            if (u.iniciarSesion(correo, contraseña)) {
                usuarioActual = u;
                System.out.println("Sesión iniciada correctamente.");
                return;
            }
        }
        System.out.println("Correo o contraseña incorrectos.");
    }

    public static void gestionarPerfil() {
        if (usuarioActual == null) {
            System.out.println("Debes iniciar sesión primero.");
            return;
        }

        System.out.println("\n--- GESTIONAR PERFIL ---");
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("Nuevo apellido: ");
        String nuevoApellido = sc.nextLine();

        usuarioActual.actualizarNombreApellido(nuevoNombre, nuevoApellido);
        System.out.println("Nombre actualizado correctamente.");
    }

    public static void verHistorial() {
        if (usuarioActual == null) {
            System.out.println("Debes iniciar sesión primero.");
            return;
        }

        System.out.println("\n--- HISTORIAL DEL USUARIO ---");
        usuarioActual.verHistorial();
    }
}