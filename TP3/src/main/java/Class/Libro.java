package Class;
import Enum.Estado;
import lombok.*;

@Data
@NoArgsConstructor
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private Estado estado;

    //CONSTRUCTOR
    public Libro(String ISBN, String titulo, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado.DISPONIBLE;
    }

}
