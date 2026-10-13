package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}