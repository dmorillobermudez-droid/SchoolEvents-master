package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lugar")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lugar")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "aforo_max", nullable = false)
    private Integer aforoMax;
}