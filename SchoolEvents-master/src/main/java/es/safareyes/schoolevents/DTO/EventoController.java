package es.safareyes.schoolevents.DTO;

import es.safareyes.schoolevents.service.EventosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventosService eventosService;

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> obtenerPorId(@PathVariable Long id) {
        EventoResponseDTO evento = eventosService.obtenerPorId(id);
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> crear(@Valid @RequestBody EventoRequestDTO requestDTO) {
        EventoResponseDTO nuevoEvento = eventosService.crearEvento(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEvento);
    }
}