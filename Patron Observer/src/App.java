public class App {
    public static void main(String[] args) {
        //Aquí se crea una instancia de la tienda.
        Tienda_Tecnologica tienda = new Tienda_Tecnologica();

         //se crean tres clientes interesados
        Cliente_Principal cliente1 = new Cliente_Interesado("Carlos");
        Cliente_Principal cliente2 = new Cliente_Interesado("Ana");
        Cliente_Principal cliente3 = new Cliente_Interesado("Pedro");

        //Los clientes se suscriben a la tienda.
        tienda.registrarCliente(cliente1);
        tienda.registrarCliente(cliente2);
        tienda.registrarCliente(cliente3);

        // Guarda el producto recibido.
        //Llama a notificarClientes(), que:
        //Recorre la lista de clientes
        //Y ejecuta el método actualizar(...) en cada uno
        
        tienda.nuevoProductoDisponible("Teléfono Samsung Galaxy S30 Ultra");
    }
}
