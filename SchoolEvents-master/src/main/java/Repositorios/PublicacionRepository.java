package Repositorios;

import es.safareyes.schoolevents.Modelos.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    List<Publicacion> findByEventoId(Integer idEvento);

    List<Publicacion> findByUsuarioId(Integer idUsuario);
}
