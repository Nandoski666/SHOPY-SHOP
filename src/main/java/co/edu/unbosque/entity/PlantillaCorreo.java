package co.edu.unbosque.entity;

import java.time.LocalDate;

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
public class PlantillaCorreo {
	
	private String remitente;
	private String destinario;
	private String asunto;
	private String cuerpoMensaje;
	private LocalDate fechaEnvio;
	private boolean estadoEnvio;

}
