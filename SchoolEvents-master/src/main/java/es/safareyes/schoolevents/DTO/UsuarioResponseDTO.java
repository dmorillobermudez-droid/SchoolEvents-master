package es.safareyes.schoolevents.DTO;

import es.safareyes.schoolevents.Modelos.RolEnum;
import lombok.Data;

@Data
public class UsuarioResponseDTO { //salida
    private Long id;
    private String nombre;
    private String email;
    private RolEnum rol;
}
