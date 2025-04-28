package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import co.edu.unbosque.entity.Cliente;
import co.edu.unbosque.service.ClienteService;

@Named("validarIngreso")
@SessionScoped
public class ValidarIngreso implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    private ClienteService clienteService = new ClienteService();
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        var sessionMap = context.getExternalContext().getSessionMap();

        // Admin (predefinido)
        if ("admin".equals(username) && "admin".equals(password)) {
            sessionMap.put("user", "admin");
            return "paginaAdmin?faces-redirect=true";
        }

        // Cliente genérico (predefinido)
        if ("cliente".equals(username) && "cliente".equals(password)) {
            sessionMap.put("user", "cliente");
            return "paginaPrincipal?faces-redirect=true";
        }

        // Clientes registrados (correo y clave)
        List<Cliente> clientes = clienteService.findAll();
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(username) && c.getClave().equals(password)) {
                sessionMap.put("user", c.getNombre());
                sessionMap.put("cliente", c);
                return "paginaPrincipal?faces-redirect=true";
            }
        }

        // Credenciales inválidas
        context.addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correo o contraseña incorrectos", null));
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .invalidateSession();
        return "principal?faces-redirect=true";
    }

    public String registrarme() {
        return "registroNuevoCliente?faces-redirect=true";
    }

    // Getters y setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
