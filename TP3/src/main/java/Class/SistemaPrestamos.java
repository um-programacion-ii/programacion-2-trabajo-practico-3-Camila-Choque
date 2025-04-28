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


    public void crearPrestamo(String isbn, Catalogo catalogo) {
        Libro libro = catalogo.buscarLibroISBN(isbn);
        if (libro == null) {
            return;
        }
        if (libro.getEstado() != Estado.DISPONIBLE) {
            return;
        }
        Prestamo prestamo = new Prestamo(LocalDate.now(), libro);
        listaPrestamos.add(prestamo);
        libro.setEstado(Estado.PRESTADO);
    }

    public void devolverPrestamo(String isbn, Catalogo catalogo) {
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
