package co.edu.unbosque.entity;

import java.time.LocalDateTime;

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

public class Compra {

	private int id;
	private LocalDateTime fechaHora;
	private double valorTotal;
	private double iva;
	private double valorUnitario;
	private boolean estado;
	
	
	
	
	
}
