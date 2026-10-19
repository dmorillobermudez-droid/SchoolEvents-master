package es.safareyes.schoolevents.service;

import es.safareyes.schoolevents.DTO.EventoRequestDTO;
import es.safareyes.schoolevents.DTO.EventoResponseDTO;
import es.safareyes.schoolevents.Modelos.Evento;
import es.safareyes.schoolevents.Repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventosService {

    @Autowired
    private EventoRepository eventoRepository;

    public EventoResponseDTO obtenerPorId(Long id) {
        // 1. Buscamos el evento en la base de datos usando el repositorio
        Evento evento = eventoRepository.findById(id).orElse(null);

        if (evento == null) {
            return null;
        }

        // 2. Mapeamos convirtiendo los IDs de Integer a Long de forma segura con .longValue()
        return new EventoResponseDTO(
                evento.getId() != null ? evento.getId().longValue() : null,
                evento.getTitulo(),
                evento.getDescripcion(),
                evento.getEstado(),
                evento.getFechaIni(),
                evento.getFechafin(),
                evento.getCategoria() != null && evento.getCategoria().getId() != null ? evento.getCategoria().getId().longValue() : null,
                evento.getLugar() != null && evento.getLugar().getId() != null ? evento.getLugar().getId().longValue() : null
        );
    }

    public EventoResponseDTO crearEvento(EventoRequestDTO requestDTO) {
        // Lógica de creación si la necesitas más adelante
        return null;
    }
}