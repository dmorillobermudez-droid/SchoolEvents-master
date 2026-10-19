package Repositorios;


import es.safareyes.schoolevents.Modelos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findByEstado(String estado);

    List<Evento> findByCategoriaId(Integer idCategoria);

    List<Evento> findByLugarId(Integer idLugar);

    List<Evento> findByFechainiAfter(LocalDateTime fecha);
}