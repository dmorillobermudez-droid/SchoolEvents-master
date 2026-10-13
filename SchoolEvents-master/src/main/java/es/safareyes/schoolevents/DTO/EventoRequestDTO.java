package es.safareyes.schoolevents.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EventoRequestDTO {
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long categoriaId;
    private Long lugarId;
}