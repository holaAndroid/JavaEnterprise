package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private String telefono;
	

}
