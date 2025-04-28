package Class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionUsuarios {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private SistemaPrestamos sistemaPrestamos;

    public void registrarUsuario(String nombre) {
        Usuario nuevoUsuario = new Usuario(nombre);
        listaUsuarios.add(nuevoUsuario);
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios;
    }

    public boolean registrarPrestamo(String nombreUsuario, Prestamo prestamo) {
        Usuario usuario = buscarUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            usuario.getHistorialPrestamos().add(prestamo);
            return true;
        }
        return false;
    }

}
