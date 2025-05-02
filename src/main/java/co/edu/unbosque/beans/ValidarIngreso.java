package co.edu.unbosque.beans;

import java.io.Serializable;
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

    private String correo;
    private String clave;

    private ClienteService clienteService = new ClienteService();
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        var sessionMap = context.getExternalContext().getSessionMap();

        // Validar campos obligatorios
        if (correo == null || correo.isBlank() || clave == null || clave.isBlank()) {
            context.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correo y contraseña son obligatorios", null));
            return null;
        }

        // Admin predefinido
        if ("admin@tuempresa.com".equalsIgnoreCase(correo) && "admin".equals(clave)) {
            sessionMap.put("user", "admin");
            return "paginaAdmin?faces-redirect=true";
        }

        // Buscar cliente por correo
        Cliente cliente = clienteService.findByEmail(correo);
        if (cliente != null) {
            System.out.println("[DEBUG] Cliente encontrado: " + cliente.getCorreo());
            if (cliente.getClave().equals(clave)) {
                sessionMap.put("user", cliente.getNombre());
                sessionMap.put("cliente", cliente);
                return "paginaPrincipal?faces-redirect=true";
            } else {
                System.out.println("[DEBUG] Clave incorrecta");
            }
        } else {
            System.out.println("[DEBUG] No existe cliente con correo: " + correo);
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
}
