package es.safareyes.schoolevents;

import es.safareyes.schoolevents.Modelos.*;
import es.safareyes.schoolevents.Repositorios.FotoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestFoto {

    @Autowired
    private FotoRepository repository;

    @Test
    void consultarFotoPorEventoId() {
        List<Foto> fotos = repository.findByEventoId(1);
        assertNotNull(fotos);
    }
}