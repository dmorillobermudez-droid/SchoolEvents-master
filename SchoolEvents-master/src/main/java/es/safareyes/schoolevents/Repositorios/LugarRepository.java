package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Long> {

    // 8. GET /api/v1/lugares[cite: 2]
    @Query(value = "SELECT l.* FROM Lugar l", nativeQuery = true)
    List<Lugar> findAllLugares();
}