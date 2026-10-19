package es.safareyes.schoolevents.DTO;

import java.time.LocalDateTime;

public record EventoResponseDTO(
        Long idEvento,
        String titulo,
        String descripcion,
        String estado,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        Long categoriaId,
        Long lugarId
) {}