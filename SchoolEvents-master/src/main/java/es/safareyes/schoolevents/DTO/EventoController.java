package es.safareyes.schoolevents.DTO;

import es.safareyes.schoolevents.service.EventoService;
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
    private EventosService eventosService; // Añadida la 's' para que coincida

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> crear(@Valid @RequestBody EventoRequestDTO requestDTO) {
        EventoResponseDTO nuevoEvento = eventoService.crearEvento(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEvento);
    }
}