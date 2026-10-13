package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // 7. GET /api/v1/categorias[cite: 2]
    @Query(value = "SELECT c.* FROM Categoria c", nativeQuery = true)
    List<Categoria> findAllCategorias();

    Optional<Categoria> findByNombre(String deportes);
}