package co.edu.unbosque.beans;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import co.edu.unbosque.entity.Cliente;
import co.edu.unbosque.service.ClienteService;

@Named("registroCliente")
@RequestScoped
public class RegistroCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String correo;
    private String clave;
    private String nombre;
    private String telefono;

    private ClienteService clienteService = new ClienteService();

    // Getters y setters…

    public String registrar() {
        if (clienteService.findByEmail(correo) != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo ya está registrado", null));
            return null;
        }

        Cliente nuevoCliente = new Cliente(0, nombre, correo, telefono, clave, false);
        if (clienteService.save(nuevoCliente)) {
            // redirige al home o login
            return "principal?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el registro", null));
            return null;
        }
    }


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    // getters & setters…
}
