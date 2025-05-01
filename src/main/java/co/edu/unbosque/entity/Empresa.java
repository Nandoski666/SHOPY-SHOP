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
public class Empresa {
	
	
	private int id;
	private String nombre;
	private String nit;
	private String telefono;
	private String direccion;
	private String correo;
	

}
