package Class;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Usuario {
    private String nombre;
    private List<Prestamo> historialPrestamos = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
}
