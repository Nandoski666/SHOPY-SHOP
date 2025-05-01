package co.edu.unbosque.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MetodoPago {
	private int id;
	private boolean estado;
	private String formaPago;
}
