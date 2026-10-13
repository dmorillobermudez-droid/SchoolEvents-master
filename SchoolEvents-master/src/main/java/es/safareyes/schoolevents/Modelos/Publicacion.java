package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "publicacion")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"evento", "usuario"})
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"evento", "usuario"})
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}