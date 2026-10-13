package es.safareyes.schoolevents.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventoResponseDTO { //salida
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String categoriaNombre;
    private String lugarNombre;
}
