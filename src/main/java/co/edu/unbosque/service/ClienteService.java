package co.edu.unbosque.service;

import co.edu.unbosque.dao.ClienteDAO;
import co.edu.unbosque.entity.Cliente;
import co.edu.unbosque.persistence.BaseDatos;

public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    /** Guarda un cliente: le asigna ID único y retorna true si se añadió */
    public boolean save(Cliente cliente) {
        // Asignar un ID único
        cliente.setId(BaseDatos.generarId());
        return clienteDAO.insertarCliente(cliente);
    }

    /** Busca un cliente por correo (case-insensitive) o null si no existe */
    public Cliente findByEmail(String correo) {
        for (Cliente c : clienteDAO.consultarTodosClientes()) {
            if (c.getCorreoCliente().equalsIgnoreCase(correo)) {
                return c;
            }
        }
        return null;
    }

    /** Devuelve todos los clientes (útil para listar) */
    public java.util.List<Cliente> findAll() {
        return clienteDAO.consultarTodosClientes();
    }
}
