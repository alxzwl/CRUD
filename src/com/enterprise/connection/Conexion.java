package com.enterprise.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public Connection getConnection() {
		Connection conexion = null;
		String url = "jdbc:mysql://localhost:3306/bd";
	    String user = "root";
		String password = "root";
		try {
			conexion = DriverManager.getConnection(url,user,password);			
			if(conexion != null) {
				System.out.println("Conexion exitosa");
			}else {
				System.out.println("Error en la conexion");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conexion;
	}
}