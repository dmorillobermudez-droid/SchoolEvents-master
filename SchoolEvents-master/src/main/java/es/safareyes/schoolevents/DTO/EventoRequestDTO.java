package es.safareyes.schoolevents.DTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record EventoRequestDTO(

        @NotBlank(message = "El título es obligatorio")
        @Size(max = 100, message = "El título no puede pasar de 100 caracteres")
        String titulo,

        @NotBlank(message = "La descripción es obligatoria")
        String descripcion,

        @NotNull(message = "La fecha de inicio es obligatoria")
        @FutureOrPresent(message = "La fecha de inicio debe ser actual o futura")
        LocalDateTime fechaInicio,

        @NotNull(message = "La fecha de fin es obligatoria")
        LocalDateTime fechaFin,

        @NotNull(message = "Debe indicar la categoría")
        Long categoriaId,

        @NotNull(message = "Debe indicar el lugar")
        Long lugarId
) {}