package co.edu.unbosque.entity;


import lombok.Data;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {


	private int id;
	private String nombre;
	private String descripcion;
	private double valorUnitario;
	private int stock;
	private int existencia;
	
	
	
}
