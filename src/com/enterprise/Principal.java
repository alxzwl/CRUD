package com.enterprise;
import com.enterprise.entity.Customer;
import com.enterprise.service.CustomerServicioImp;

public class Principal {

	public static void main(String[] args) {
		CustomerServicioImp servicio = new CustomerServicioImp(); 
		// Consulta General BBDD
		//System.out.println(servicio.listaCustomers());
		
		// Se crea un objeto de tipo Customer
		Customer customer = new Customer("Gonzalo","Gonzalo","gonzalo@correo.com","5544117722");
		
		// Se agrega un nuevo customer a BBDD
		System.out.println(servicio.guardaCustomer(customer));

		// Salida en pantalla de la lista de los customers
		System.out.println(servicio.listaCustomers());
		System.out.println("\n");

		// Regresa un registro por id
		//System.out.println(servicio.customerPorId(2));

		// Actualiza un registro en BBDD
		//Customer customer = new Customer("Pepe","Ponce","pepe@correo.com","5566445544");
		//System.out.println(servicio.actualizaCustomer(customer, 1));

		// Borra un registro en BBDD
		//System.out.println(servicio.eliminaCustomer(3));
	}

}
