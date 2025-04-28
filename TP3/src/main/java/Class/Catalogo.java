package Class;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;



@ToString
public class Catalogo {

    private List <Libro> listaLibros;

    public Catalogo() {
        this.listaLibros = new ArrayList<>();  // Asegúrate de inicializar la lista aquí
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarLibroISBN(String ISBN) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return listaLibros;
    }
}
