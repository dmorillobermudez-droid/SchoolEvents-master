package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"eventosOrganizados", "notificaciones"})
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"eventosOrganizados", "notificaciones"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private RolEnum rol;

    @ManyToMany
    @JoinTable(
            name = "usuario_organiza_evento",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_evento")
    )
    private Set<Evento> eventosOrganizados = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "usuario_notificacion",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_notificacion")
    )
    private Set<Notificacion> notificaciones = new HashSet<>();

    @PrePersist
    public void prePersist() {
        if (this.fechaInscripcion == null) {
            this.fechaInscripcion = LocalDate.now();
        }
    }
}
