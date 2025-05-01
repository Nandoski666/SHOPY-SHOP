package co.edu.unbosque.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Usuario {

	protected int id;
	protected String nombre; 
	protected String correo;
	protected String clave;
	protected String telefono;
	protected boolean estado;
	
	
}
