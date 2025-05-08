package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="Cliente.findAll")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="correo_cliente")
	private String correoCliente;

	@Column(name="direccion_cliente")
	private String direccionCliente;

	private byte estado;

	private int id;

	@Column(name="nombre_cliente")
	private String nombreCliente;

	private String telefono;

	public Cliente(int i, String nombre, String correo, String telefono2, String clave, boolean b) {
	}

	public String getCorreoCliente() {
		return this.correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getDireccionCliente() {
		return this.direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Object getClave() {
		// TODO Auto-generated method stub
		return null;
	}



}