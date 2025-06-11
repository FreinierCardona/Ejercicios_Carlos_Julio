package ProgramacionOrientada.src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static List<Book> books = new ArrayList<>();
    static List<Reader> readers = new ArrayList<>();
    static List<Loan> loans = new ArrayList<>();

    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        int option =0;
    
        do{
            System.out.println("SISTEMA DE BIBLIOTECA");
            System.out.println("Ingrese los valores numericos enteros dependiendo la Situacion.");
            System.out.println(" 1. Registrar Libros");
            System.out.println(" 2. Registrar Usuario/Lector");
            System.out.println(" 3. Registrar Prestamo");
            System.out.println(" 4. Listar Libros");
            System.out.println(" 5. Listar Usuarios/Lector");
            System.out.println(" 6. Listar Prestamo");
            System.out.println(" 7. Buscar Prestamo");
            System.out.println(" 8. Salir");
            System.out.println("");
            System.out.print(" Ingrese la Opcion: ");
            option= sc.nextInt();
            System.out.println("");
            sc = new Scanner(System.in);

            switch (option) {
                case 1:{
                    registerBook();
                }
                    
                    break;
                case 2:{
                    registerUser();
                }
                    
                    break;
                case 3:{
                    registerLoan();
                }
                    
                    break;
                case 4:{
                    listBook();
                }
                    
                    break;
                case 5:{
                    listUser();
                }
                    
                    break;
                case 6:{
                    listLoan();
                }
                    
                    break;
                case 7:{
                    busquedaPrestamo();
                }
                    
                    break;
            
            
                default:
                    break;
            }
          
        }  while(option!=8);
        System.out.println("Has Salido del sistema.");

    }



    public static void registerBook(){
        Book book = new Book(0, null, null, null, null);
        System.out.println("REGISTRAR LIBRO");
            System.out.println("");
    while (true) {
            System.out.print("Ingrese código ISBN: ");
            int isbn = sc.nextInt();
            sc.nextLine(); 

            boolean isbnExists = false;
            for (Book b : books) {
                if (b.isbn == isbn) {
                    isbnExists = true;
                    break;
                }
            }

            if (isbnExists) {
                System.out.println("Error: El ISBN ya está registrado. Intente de nuevo.");
            } else {
                book.isbn = isbn;
                break;
            }
        }
        System.out.print("Titulo: ");
        book.title = sc.nextLine();

        System.out.print("Autor: ");
        book.author = sc.nextLine();

        System.out.print("Genero: ");
        book.genere = sc.nextLine();

        System.out.print("Fecha de Publicacion (YYYY-MM-DD): ");
        String dateInput = sc.nextLine();
        book.publicationDate = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);

        books.add(book);
        
        System.out.println("Registro EXITOSO");
    }




    public static void registerUser(){
        Reader reader = new Reader(null, null, 0, null);
        System.out.println("REGISTRO DE USUARIO");
             System.out.println("");

        System.out.println("Nombre: ");
        reader.name= sc.nextLine();
    
        System.out.println("Apellido: ");
        reader.lastName = sc.nextLine();

        System.out.println("Numero de Identificacion: ");
        reader.id=sc.nextInt();
        sc.nextLine();

        System.out.println("Correo Electronico: ");
        reader.email = sc.nextLine();
         
        readers.add(reader);
        System.out.println("Registro EXITOSO");
       
    }




    public static void registerLoan(){
        if (books.isEmpty()||readers.isEmpty()){
            System.out.println("Lista Vacia, Registre un elemento");
            return;
        }
        System.out.println("Analice los libros: ");
        listBook();

        System.out.println("Elije un numero del libro: ");
        int  iterationBook = sc.nextInt()-1;
        sc.nextLine();

        System.out.println("Analice los usuarios: ");
        listUser();

        System.out.println("Elije un numero para seleccionar el usuario: ");
        int iterationUser = sc.nextInt()-1;
        sc.nextLine();

        System.out.println("Digite la fecha de prestamo (YYYY-MM-DD): ");
        String dateInput=sc.nextLine();
        LocalDate loanDate=LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Digite la fecha Estimada de Entrega (YYYY-MM-DD): ");
        String input=sc.nextLine();

        LocalDate returnDate=LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
    Loan loan = new Loan(books.get(iterationBook), readers.get(iterationUser), loanDate, returnDate);
loans.add(loan);
             System.out.println("Registro EXITOSO");
    }


    public static void listBook(){
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
        if (books.size() == 0) {
            System.out.println("No hay libros registrados");
        }
    }



    public static void listUser(){
         for (int i = 0; i < readers.size(); i++) {
            System.out.println(readers.get(i).toString());
        }
        if (readers.size() == 0) {
            System.out.println("No hay Usuarios registrados");
        }
    }



    public static void listLoan(){
         for (int i = 0; i < loans.size(); i++) {
            System.out.println(loans.get(i).toString());
        }
        if (loans.size() == 0) {
            System.out.println("No hay libros registrados");
        }
    }




    public static void busquedaPrestamo(){
        if (loans.isEmpty()) {
        System.out.println("No hay préstamos registrados.");
        return;
    }
    
    System.out.println("Seleccione el criterio de búsqueda:");
    System.out.println("1. Buscar por título de libro");
    System.out.println("2. Buscar por nombre del lector");
    System.out.print("Ingrese una opción (1 o 2): ");
    int opcion = sc.nextInt();
    sc.nextLine(); 
    
    if (opcion == 1) { 
        System.out.print("Ingrese el título del libro: ");
        String criterio = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        

        for (Loan loan : loans) {
            if (loan.book.title.toLowerCase().contains(criterio)) {
                System.out.println(loan.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún préstamo cuyo libro contenga: " + criterio);
        }
    } else if (opcion == 2) {  
        System.out.print("Ingrese el nombre del lector: ");
        String criterio = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        

        for (Loan loan : loans) {
            if (loan.reader.name.toLowerCase().contains(criterio)) {
                System.out.println(loan.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún préstamo cuyo lector contenga: " + criterio);
        }
    } else {
        System.out.println("Opción no válida. Debe elegir 1 o 2.");
    }
    }
}
