public class Cliente_Interesado implements Cliente_Principal {
    private String nombre;

    //Guarda el nombre que se recibe por parámetro.
    public Cliente_Interesado(String nombre) {
        this.nombre = nombre;
    }

    //@Override indica que estás reescribiendo el método de la interfaz.
    //Aquí defines qué hace este cliente cuando recibe una notificación.
    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió notificación: " + mensaje);
    }
}