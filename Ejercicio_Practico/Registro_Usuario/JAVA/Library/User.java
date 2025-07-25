
import java.util.ArrayList;

public class User {
    public String nombre;
    public String apellido;
    public String correo;
    public String contraseña;
    public ArrayList<String> historial;

    public User(String nombre, String apellido, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.historial = new ArrayList<>();
        historial.add("Usuario registrado");
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        return this.correo.equals(correo) && this.contraseña.equals(contraseña);
    }

    public void actualizarNombreApellido(String nuevoNombre, String nuevoApellido) {
        this.nombre = nuevoNombre;
        this.apellido = nuevoApellido;
        historial.add("Actualizó nombre a: " + nuevoNombre + " " + nuevoApellido);
    }

    public void verHistorial() {
        System.out.println("Historial de cambios:");
        for (String cambio : historial) {
            System.out.println("- " + cambio);
        }
    }
}