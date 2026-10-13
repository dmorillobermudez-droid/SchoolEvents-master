package es.safareyes.schoolevents;

import es.safareyes.schoolevents.Modelos.*;
import es.safareyes.schoolevents.Repositorios.EventoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestEvento {

    @Autowired
    private EventoRepository repository;

    @Test
    void consultarEventoPorEstado() {
        List<Evento> eventos = repository.findByEstado("ACTIVO");
        assertNotNull(eventos);
    }
}