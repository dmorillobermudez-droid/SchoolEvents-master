package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "requisitos")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Requisitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requisito")
    private Integer id;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
}