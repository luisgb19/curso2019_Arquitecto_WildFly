package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import model.Contacto;

/**
 * Session Bean implementation class DaoContactosImp
 */
@Stateless
public class DaoContactosImp implements DaoContactos {

	@Resource(mappedName = "java:comp/env/refcontactos", type = javax.sql.DataSource.class)
	DataSource ds;
	@Override
	public void altaContacto() {
		try(Connection con=ds.getConnection();){
			String sql="insert into contactos(nombre,email,edad) values(";
			sql+="'jdbc','jdbc@gmail.com',50)";
			Statement st=con.createStatement();
			st.execute(sql);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void altaContacto(Contacto contacto) {

		String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
		
		try(Connection con=ds.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);){
			// Dentro del try son autocerrables
			pst.setString(1, contacto.getNombre());
			pst.setString(2, contacto.getEmail());
			pst.setInt(3, contacto.getEdad());
			pst.execute();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<Contacto> mostrarContactos() {

		String sql="select * from contactos";
		List<Contacto> list = new ArrayList<>();
		
		try(Connection con=ds.getConnection();
			Statement s = con.createStatement();				
			ResultSet rs = s.executeQuery(sql);){
			while (rs.next())
			{
				Contacto contacto = new Contacto(rs.getInt (1),rs.getString(2),rs.getString(3),rs.getInt(4));
				list.add(contacto);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}		
		return list;
	}

	@Override
	public void eliminarContacto(Integer id) {

		String sql="delete from contactos where idContacto=?";
		
		try(Connection con=ds.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);){
			// Dentro del try son autocerrables
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
