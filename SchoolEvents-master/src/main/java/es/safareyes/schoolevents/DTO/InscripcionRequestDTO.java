package es.safareyes.schoolevents.DTO;

import lombok.Data;

@Data
public class InscripcionRequestDTO {
    private Long usuarioId;
    private Long eventoId;
}