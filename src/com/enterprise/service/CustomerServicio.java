package com.enterprise.service;

import java.util.List;

import com.enterprise.entity.Customer;

public interface CustomerServicio {

	public List<Customer> listaCustomers();
	
	public String guardaCustomer(Customer customer); 

	public Customer customerPorId(int id);
	
	public String actualizaCustomer(Customer customer, int id);
	
	public String eliminaCustomer(int id);
	
}
