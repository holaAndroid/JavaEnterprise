package model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Venta {
	private int idVenta;
	private int idCliente;
	private int idLibro;
	private LocalDateTime fecha;

}
