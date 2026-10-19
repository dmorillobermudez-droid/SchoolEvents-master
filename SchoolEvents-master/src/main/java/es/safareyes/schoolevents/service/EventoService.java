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
        // 1. Buscamos el evento en la base de datos
        Evento evento = eventoRepository.findById(id).orElse(null);

        if (evento == null) {
            return null;
        }

        // 2. Como EventoResponseDTO es un record, lo instanciamos con el constructor
        // (Ajusta los campos en orden según cómo tengas definido tu EventoResponseDTO)
        return new EventoResponseDTO(
                evento.getIdEvento(),
                evento.getTitulo(),
                evento.getDescripcion(),
                evento.getEstado()
                // Añade el resto de campos que requiera el constructor de tu EventoResponseDTO
        );
    }

    public EventoResponseDTO crearEvento(EventoRequestDTO requestDTO) {
        return null;
    }
}