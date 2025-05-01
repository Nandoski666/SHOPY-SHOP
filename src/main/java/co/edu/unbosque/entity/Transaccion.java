package co.edu.unbosque.entity;

import java.time.LocalDate;

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
public class Transaccion {
	private int id;
	private LocalDate fechaPago;
	private double valorPago;
}
