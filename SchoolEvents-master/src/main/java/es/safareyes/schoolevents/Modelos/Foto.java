package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foto")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"evento", "publicacion", "curso", "usuarios"})
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"evento", "publicacion", "curso", "usuarios"})
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Integer id;

    @Column(name = "url_foto", nullable = false, length = 255)
    private String urlFoto;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publicacion")
    private Publicacion publicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToMany
    @JoinTable(
            name = "usuario_sube_foto",
            joinColumns = @JoinColumn(name = "id_foto"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private Set<Usuario> usuarios = new HashSet<>();

    @PrePersist
    public void prePersist() {
        if (this.fechaPublicacion == null) {
            this.fechaPublicacion = LocalDateTime.now();
        }
    }
}