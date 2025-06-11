package ProgramacionOrientada.src;

public class Reader {

    public String name;
    public String lastName;
    public int id;
    public String email;

    public Reader(String name, String lastName, int id, String email){
        this.name = name;
        this.lastName = lastName;
        this.id  = id;
        this.email = email;
    }
    @Override
    public String toString(){
        return "LECTOR: [ Nombre: "+name+" | Apellido: "+lastName+" | Identificacion: "+id+" | Correo: "+email+" ]";
    }
}