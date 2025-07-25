package Ejercicio_Practico.Inventario.JAVA.Library;
public class Producto {
    public String nombre;
    public String codigo;
    public double precio;
    public int stock;
    public String categoria;

    public Producto(String nombre, String codigo, double precio, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = 0;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto: [Nombre: " + nombre + ", Código: " + codigo + ", Precio: $" + precio +
               ", Stock: " + stock + ", Categoría: " + categoria + "]";
    }
}
