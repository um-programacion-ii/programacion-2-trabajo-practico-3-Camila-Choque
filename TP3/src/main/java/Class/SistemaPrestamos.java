package Class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import Enum.Estado;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SistemaPrestamos {
    private Catalogo catalogo;
    private List<Prestamo> listaPrestamos = new ArrayList<>();


    public Prestamo crearPrestamo(String isbn) {
        Libro libro = catalogo.buscarLibroISBN(isbn);
        if (libro == null || libro.getEstado() != Estado.DISPONIBLE) {
            return null;
        }
        Prestamo prestamo = new Prestamo(LocalDate.now(), libro);
        libro.setEstado(Estado.PRESTADO);
        return prestamo;
    }

    public void devolverLibro(String isbn, Catalogo catalogo) {
        Libro libro = catalogo.buscarLibroISBN(isbn);
        if (libro == null) {
            return;
        }
        if (libro.getEstado() != Estado.PRESTADO) {
            return;
        }
        libro.setEstado(Estado.DISPONIBLE);
    }

}
