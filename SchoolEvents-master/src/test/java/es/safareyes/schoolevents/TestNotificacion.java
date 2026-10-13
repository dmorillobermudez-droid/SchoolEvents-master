package es.safareyes.schoolevents;

import es.safareyes.schoolevents.Modelos.*;
import es.safareyes.schoolevents.Repositorios.NotificacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestNotificacion {

    @Autowired
    private NotificacionRepository repository;

    @Test
    void consultarNotificacionPorId() {
        Optional<Notificacion> notificacion = repository.findById(1);
        assertNotNull(notificacion);
    }
}