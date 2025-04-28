package Class;

import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;


@NoArgsConstructor
@ToString
public class Catalogo {

    private List <Libro> listaLibros;

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
