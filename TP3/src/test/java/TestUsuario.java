import Class.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestUsuario {
    @Mock
    private Catalogo catalogo;
    @Mock
    private SistemaPrestamos sistemaPrestamos;
    @InjectMocks
    private GestionUsuarios gestionUsuarios;
    private Usuario usuario;
    private Libro libro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios.setListaUsuarios(new ArrayList<>());
        usuario = new Usuario("usuario1");
        libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
    }

    @Test
    void testRegistrarPrestamos() {
        gestionUsuarios.getListaUsuarios().add(usuario);
        when(catalogo.buscarLibroISBN("978-3-16-148410-0")).thenReturn(libro);
        Prestamo prestamo = new Prestamo(LocalDate.now(), libro);
        when(sistemaPrestamos.crearPrestamo("978-3-16-148410-0"))
                .thenReturn(prestamo);
        gestionUsuarios.registrarPrestamo("usuario1", "978-3-16-148410-0");
        verify(sistemaPrestamos).crearPrestamo("978-3-16-148410-0");
        assertEquals(1, usuario.getHistorialPrestamos().size());
    }

    @Test
    void testRegistrarPrestamoUsuarioNoEncontrado() {
        when(catalogo.buscarLibroISBN("978-3-16-148410-0")).thenReturn(libro);
        boolean resultado = gestionUsuarios.registrarPrestamo("usuarioInexistente", "978-3-16-148410-0");
        assertFalse(resultado);
        verifyNoInteractions(sistemaPrestamos);
        verifyNoInteractions(catalogo);
    }

    @Test
    void testRegistrarPrestamoIsbnNull() {
        gestionUsuarios.getListaUsuarios().add(usuario);
        when(sistemaPrestamos.crearPrestamo(null)).thenReturn(null);
        boolean resultado = gestionUsuarios.registrarPrestamo("usuario1", null);
        verify(sistemaPrestamos).crearPrestamo((String) null);
        assertTrue(resultado);
        assertEquals(1, usuario.getHistorialPrestamos().size());
        assertNull(usuario.getHistorialPrestamos().get(0));
    }
}