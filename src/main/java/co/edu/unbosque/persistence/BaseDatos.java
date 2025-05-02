package co.edu.unbosque.persistence;

import java.util.ArrayList;

import java.util.Date;
import java.util.Calendar;

import co.edu.unbosque.entity.Cliente;


public class BaseDatos {


	
	public static ArrayList<Cliente> tablaCliente = new ArrayList<>();
	public static int generarId() {
	    int maxId = 0;
	    for (Cliente c : tablaCliente) {
	        if (c.getId() > maxId) {
	            maxId = c.getId();
	        }
	    }
	    return maxId + 1;
	}

	
	
}