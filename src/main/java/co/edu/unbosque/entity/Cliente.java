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

public class Cliente extends Usuario {

    private String direccion;
    private LocalDate fechaRegistro;

    public Cliente(int id, String nombre, String correo, String telefono, String clave, boolean estado) {
        super(id, nombre, correo, clave, telefono, estado);
        this.fechaRegistro = LocalDate.now();
        // si quieres inicializar `direccion`, hazlo aquí
    }

    // ...
}
