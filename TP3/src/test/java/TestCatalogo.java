import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Class.*;
import java.util.List;


public class TestCatalogo {
    Catalogo catalogo;
    Libro libro1;
    Libro libro2;


    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        libro2 = new Libro("978-0-13-235088-4", "Clean Architecture", "Robert C. Martin");
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    @Test
    void testBuscarPorIsbn() {
        Libro libro = catalogo.buscarLibroISBN("978-3-16-148410-0");
        assertNotNull(libro);
        assertEquals("Clean Code", libro.getTitulo());
    }

    @Test
    void testBucarPorIsbnFallida(){
        Libro libro = catalogo.buscarLibroISBN("978-0-13-235088-5");
        assertNull(libro);
    }

    @Test
    public void testMostrarTodosLosLibros() {
        List<Libro> libros = catalogo.obtenerTodosLosLibros();
        assertNotNull(libros);
        assertEquals(2, libros.size());
        assertTrue(libros.contains(libro1));
        assertTrue(libros.contains(libro2));

    }
}
