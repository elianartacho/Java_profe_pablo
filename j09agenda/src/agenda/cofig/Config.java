package agenda.cofig;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class Config {

	//queremos el objeto source en modi singlelton
	private static DataSource ds;
	private static Properties prop;
	
	private Config(){};
	
	
	public static DataSource getDataSource() {
		//la primera vez es null asi que lo creamos
		if(ds == null) {
			BasicDataSource bds = new BasicDataSource();
			Properties prop = getProp();
			bds.setUrl(prop.getProperty("bbdd.url"));
			bds.setDriverClassName("bbdd.driver");
			bds.setUsername("bbdd.user");
			bds.setPassword("bbdd.pass");
			ds = bds;
			
		}
		
		return ds;
	}
	
	
	//cuando se ejecute lo va a meter en la memoria 
	//usara un mapa porque hereda de Hastable la clase properties es un mapa
	public static Properties getProp() {
		if(prop == null) {
			prop = new Properties();	
		
		try (FileReader fr = new FileReader("app.properties")){
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("No se puede leer el fichero properties");
			
			}
		}
		return prop;
	}
	
}
