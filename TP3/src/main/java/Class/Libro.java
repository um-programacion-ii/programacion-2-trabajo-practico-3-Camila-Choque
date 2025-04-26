package Class;
import Enum.Estado;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private Estado estado;



    //CONSTRUCTOR
    public Libro(String ISBN, String titulo, String autor, Estado estado) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
    }

    //GETTER

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Estado getEstado() {
        return estado;
    }

    //SETTER

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
