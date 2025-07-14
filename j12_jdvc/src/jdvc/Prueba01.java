package jdvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class Prueba01 {

	public static void main(String[] args) {
		//datasource implementa la libreria de java
		BasicDataSource bds = new BasicDataSource();
		//indicamos la url
		bds.setUrl("jdbc:mysql://localhost:3366/11_agenda");
		//el driver
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//indicamos el nombre
		bds.setUsername("root");
		//indicamos la contraseña
		bds.setPassword("root");
		
		//esto es una referencia de interfaz
		//la creacion del datasource debe ser independiente
		DataSource ds = bds;
		
		try(Connection cx = ds.getConnection()){
			PreparedStatement ps = cx.prepareStatement("select nombre ,apodo from contactos where idcontactos <30 ");
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("nombre")+ "-" + rs.getString("apodo"));
			}
		}catch(SQLException e) {
			//me libera la conexion
			e.printStackTrace();
		}
	}
}
