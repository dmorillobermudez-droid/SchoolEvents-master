package Repositorios;

import es.safareyes.schoolevents.Modelos.Requisitos; // Si usas Requisitos.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitosRepository extends JpaRepository<Requisitos, Integer> {
}