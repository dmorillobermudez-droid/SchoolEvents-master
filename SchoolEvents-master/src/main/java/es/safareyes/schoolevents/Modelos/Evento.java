package es.safareyes.schoolevents.Modelos;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "evento")

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer id;

    @Column(name = "titulo",nullable = false, length=150)
    private String titulo;

    @Column(name ="descripcion",columnDefinition = "TEXT")
    private String descripcion;

    @Column(name="fecha_inicio",nullable = false)
    private LocalDateTime fechaIni;

    @Column(name="fecha_fin",nullable = false)
    private LocalDateTime fechafin;

    @Column(name="fecha_limite",nullable = false)
    private LocalDateTime fechalimite;

    @Column(name="estado", length =50)
    private String estado;

    //5
    @ManyToOne (fetch = FetchType.LAZY)//Para las claves foraneas cada evento tiene lugar y categoria
    @JoinColumn(name ="id_lugar")
    private Lugar lugar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    //6 Mapeo de relaciones

    @ManyToMany
    @JoinTable(
            name = "evento_requisito",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_requisito")
    )
    private Set<Requisitos> requisitos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "evento_curso",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<Curso>cursos=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "evento_notificacion",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_notificacion")
    )
    private Set<Notificacion>notificaciones=new HashSet<>();

    // Mapeo bidireccional de los usuarios organizadores
    @ManyToMany(mappedBy = "eventosOrganizados")
    private Set<Usuario> organizadores = new HashSet<>();







}
