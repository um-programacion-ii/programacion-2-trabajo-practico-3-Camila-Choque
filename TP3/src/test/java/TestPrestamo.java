import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import Class.*;
import Enum.Estado;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestPrestamo {
    @Mock
    private Catalogo catalogo;

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testcrearPrestamo() {
        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        when(catalogo.buscarLibroISBN("978-3-16-148410-0")).thenReturn(libro);
        Prestamo prestamo = sistemaPrestamos.crearPrestamo("978-3-16-148410-0",catalogo);
        assertNotNull(prestamo);
        verify(catalogo).buscarLibroISBN("978-3-16-148410-0");
        assertEquals(Estado.PRESTADO, libro.getEstado());
    }

    @Test
    void testDevolverLibro() {
        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        libro.setEstado(Estado.PRESTADO);
        when(catalogo.buscarLibroISBN("978-3-16-148410-0")).thenReturn(libro);
        sistemaPrestamos.devolverLibro("978-3-16-148410-0", catalogo);
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
        verify(catalogo).buscarLibroISBN("978-3-16-148410-0");
    }
}
