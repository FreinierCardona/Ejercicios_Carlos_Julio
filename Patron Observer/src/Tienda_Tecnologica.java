import java.util.ArrayList;
import java.util.List;

public class Tienda_Tecnologica {
    //Es una lista de clientes que implementan la interfaz Cliente_Principal.
    private List<Cliente_Principal> clientes = new ArrayList<>();
    private String producto;

    //Permite agregar un cliente a la lista de observadores.
    public void registrarCliente(Cliente_Principal cliente) {
        clientes.add(cliente);
    }

    //Permite dar de baja un cliente (que ya no quiere ser notificado).
    public void removerCliente(Cliente_Principal cliente) {
        clientes.remove(cliente);
    }

    //Este método recorre toda la lista de clientes suscritos.
    //Llama al método actualizar(...) de cada uno.
    //Les envía un mensaje personalizado con el nombre del producto.
    public void notificarClientes() {
        for (Cliente_Principal cliente : clientes) {
            cliente.actualizar("¡Ya llegó el producto: " + producto + "!");
        }
    }

    // Este método simula que llega un nuevo teléfono u otro producto a la tienda.
    //Luego llama a notificarClientes() para avisar a todos los que están registrados.
    public void nuevoProductoDisponible(String producto) {
        this.producto = producto;
        System.out.println("📦 La tienda recibió: " + producto);
        notificarClientes();
    }
}