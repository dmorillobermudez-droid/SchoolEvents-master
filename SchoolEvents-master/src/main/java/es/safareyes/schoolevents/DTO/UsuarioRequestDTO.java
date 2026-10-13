package es.safareyes.schoolevents.DTO;

import es.safareyes.schoolevents.Modelos.RolEnum;
import lombok.Data;

@Data
public class UsuarioRequestDTO { //entrada
    private String nombre;
    private String email;
    private String password;
    private RolEnum rol;
}