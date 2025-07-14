package agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import agenda.cofig.Config;
import agenda.modelo.Contacto;
import agenda.modelo.Domicilio;


public class ContactoDaoJDBC implements ContactoDao{

	private DataSource ds;
	
	public ContactoDaoJDBC() {
		ds = Config.getDataSource();
	}
	
	
	@Override
	public void insertar(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eliminar(int idContacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Contacto c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscar(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		//estoy creando un objeto contacto 
		Set<Contacto> resu = new HashSet<Contacto>();
		
		//me estoy conectando y lo meto en try catch para solventar errores porque es una excepcion cheked 
		try (Connection con = ds.getConnection()){
			//aqui meto la consulta
		String sql = "select idcontactos,nombre,apellidos,apodo"
		+"tipo_via,via,numero,piso,puerta,codigo_postal,ciudad,provincia"
		+ "from contactos";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Contacto c = new Contacto();
			c.setIdContacto(rs.getInt("idcontacto"));
			c.setNombre(rs.getString("nombre"));
			c.setApellidos(rs.getString("apellidos"));
			c.setApodo(rs.getString("apodo"));
			Domicilio dom = new Domicilio();
			dom.setTipoVia(rs.getNString("tipo_via"));
			dom.setVia(rs.getString("via"));
			dom.setNumero(rs.getInt("numero"));
			dom.setPiso(rs.getInt("piso"));
			dom.setPuerta(rs.getString("puerta"));
			dom.setCodigoPostal(rs.getString("codigo_postal"));		
			dom.setCiudad(rs.getString("ciudad"));
			dom.setProvincia(rs.getString("provincia"));
			c.setDom(dom);
			//faltan correos y telefonos
			resu.add(c);
			
		}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resu;
	}

	
}

