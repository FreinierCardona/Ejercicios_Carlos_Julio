package ProgramacionOrientada.src;
import java.time.LocalDate;

public class Book {

    public int isbn;
    public String title;
    public String author;
    public String genere;
    public LocalDate publicationDate;

    public Book(int isbn,String title, String author, String genere, LocalDate publicationDate ){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
       this.genere = genere;
        this.publicationDate = publicationDate;
    }
    @Override
    public String toString(){
        return "LIBRO: [isbn: "+isbn+" | Titulo: "+title+" | Autor: "+author+" | Genero: "+genere
        +" | Fecha de Publicacion: "+publicationDate+" ]";
    }
    }