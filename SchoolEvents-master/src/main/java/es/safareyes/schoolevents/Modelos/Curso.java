package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curso")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "promocion", length = 50)
    private String promocion;
}
