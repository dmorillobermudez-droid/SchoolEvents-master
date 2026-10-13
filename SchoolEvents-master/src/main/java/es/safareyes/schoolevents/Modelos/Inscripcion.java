package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"evento", "usuario"})
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"evento", "usuario"})
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "estado", length = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @PrePersist
    public void prePersist() {
        if (this.fecha == null) {
            this.fecha = LocalDateTime.now();
        }
    }
}