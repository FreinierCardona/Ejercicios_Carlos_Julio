package ProgramacionOrientada.src;
import java.time.LocalDate;

public class Loan {
    public Loan(){

    }
    public LocalDate loanDate;
    public LocalDate returnDate;
    public Reader reader;
    public Book book;

    public Loan (Book book,Reader reader,LocalDate loanDate, LocalDate returnDate){
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.book=book;
        this.reader=reader;
    }
    @Override
    public String toString(){
        return "PRESTAMO: [ LIBRO: "+book.title+" | LECTOR: "+reader.name+" "+reader.lastName+" | Fecha de prestamo: "+loanDate+" | Fecha de Devolucion: "+returnDate+"]";
    }

}
