package es.safareyes.schoolevents.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class InscripcionResponseDTO {
    private Long id;
    private String usuarioNombre;
    private String eventoTitulo;
    private LocalDateTime fechaInscripcion;
}
