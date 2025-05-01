package co.edu.unbosque.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter

public class Cliente extends Usuario{


	 public Cliente(int i, String nombre, String correo, String telefono, String clave, boolean b) {
		// TODO Auto-generated constructor stub
	}
private String direccion;
private LocalDate fechaRegistro;

}