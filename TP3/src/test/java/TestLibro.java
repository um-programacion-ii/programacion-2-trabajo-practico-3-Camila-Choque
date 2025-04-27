import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Class.Libro;
import Enum.Estado;

public class TestLibro {
    @Test
    void testCrearLibroValido() {

        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");

        assertEquals("978-3-16-148410-0", libro.getISBN());
        assertEquals("Clean Code", libro.getTitulo());
        assertEquals("Robert C. Martin", libro.getAutor());
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }

    @Test
    void testCambioEstado() {
        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");

        // Cambia el estado del libro a PRESTADO
        libro.setEstado(Estado.PRESTADO);
        // Comprueba que el estado ha cambiado correctamente
        assertEquals(Estado.PRESTADO, libro.getEstado());

    }
}
