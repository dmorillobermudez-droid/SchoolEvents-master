package Repositorios;


import es.safareyes.schoolevents.Modelos.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {

    List<Foto> findByEventoId(Integer idEvento);

    List<Foto> findByPublicacionId(Integer idPublicacion);

    List<Foto> findByCursoId(Integer idCurso);
}
