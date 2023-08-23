package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;
//Esto es un JavaBean
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Pagina {
private String direccion;
private String tematica;
private String descripcion;
}
