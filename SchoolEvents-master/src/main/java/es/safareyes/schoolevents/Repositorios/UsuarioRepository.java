package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // 16. GET /api/v1/informes/participacion?desde=&hasta=[cite: 2]
    @Query(value = "SELECT c.nombre AS categoria, cur.nombre AS curso, COUNT(DISTINCT i.id_inscripcion) AS total " +
            "FROM Evento e " +
            "JOIN Categoria c ON e.id_categoria = c.id_categoria " +
            "LEFT JOIN Evento_Curso ec ON e.id_evento = ec.id_evento " +
            "LEFT JOIN Curso cur ON ec.id_curso = cur.id_curso " +
            "LEFT JOIN Inscripcion i ON e.id_evento = i.id_evento AND i.estado = 'CONFIRMADA' " +
            "WHERE e.fecha_inicio >= :desde AND e.fecha_fin <= :hasta " +
            "GROUP BY c.nombre, cur.nombre",
            nativeQuery = true)
    List<Object[]> findInformeParticipacion(@Param("desde") LocalDateTime desde, @Param("hasta") LocalDateTime hasta);

    Optional<Usuario> findByEmail(String mail);
}