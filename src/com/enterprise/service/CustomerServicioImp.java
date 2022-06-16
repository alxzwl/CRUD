package com.enterprise.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.connection.Conexion;
import com.enterprise.entity.Customer;

public class CustomerServicioImp implements CustomerServicio {
	
	// Metodo que regresa una lista de customers
	public List<Customer> listaCustomers() {
		
		// Se crea la conexion
		Conexion conexion = new Conexion();

		// Se crea un obj de tipo Connection al que se le pasa la conexion
		Connection con = conexion.getConnection();

		// Se declara el query a BBDD
		String query = "SELECT * FROM customer";
		
		// Se crea una Lista de Customers
		List<Customer> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			// Este while recorre el resultSet
			while(rs.next()) {
				// Se setean los datos para nuevos clientes 
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				customer.setNombre(rs.getString(2));
				customer.setApellidos(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setTelefono(rs.getString(5));

				// Se agrega el customer a la lista
				list.add(customer);
			}
			// Se cierra el statement
			st.close();

			// Se cierra el resultSet
			rs.close();

			// Se cierra la conexion 
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		// El metodod regresa un objeto de tipo List
		return list;
	}

	// Se desarrolla el metodo que inserta un nuevo customer a BBDD
	public String guardaCustomer(Customer customer) {
		// Se declara la conexion
		Conexion conexion = new Conexion();
		// Se declara un objeto de tipo Connection y se le pasa la conexion
		Connection con = conexion.getConnection();
		// query que inserta un nuevo registro
		String query = "INSERT INTO customer(id, nombre, apellidos, email, telefono) VALUES("+null+",'"+customer.getNombre()+"','"+customer.getApellidos()+"','"+customer.getEmail()+"','"+customer.getTelefono()+"')";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			// Se ejecuta el preparedStatement
			ps.execute();

			// Se cierra el preparedStatement
			ps.close();
			
			// Se cierra la conexion
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Registro Guardado de forma exitosa";
	}

	public Customer customerPorId(int id) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Customer customer = new Customer();
		String query = "SELECT * FROM customer WHERE id = "+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				customer.setId(id);
				customer.setNombre(rs.getString(2));
				customer.setApellidos(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setTelefono(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public String actualizaCustomer(Customer customer, int id) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Customer customerExistente = new Customer();
		String query = "UPDATE customer SET nombre='"+customer.getNombre()+"',apellidos='"+customer.getApellidos()+"',email='"+customer.getEmail()+"',telefono='"+customer.getTelefono()+"' WHERE id="+id;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "\nRegistro Actualizado de forma exitos";
	}

	public String eliminaCustomer(int id) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		String query = "DELETE FROM customer WHERE id='"+id+"'";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "\nRegistro borrado de forma exitosa";
	}
}
