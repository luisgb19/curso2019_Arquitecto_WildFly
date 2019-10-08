package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;

@Stateless
public class DaoClientesImpl implements DaoClientes {
	
@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
	@Override
	public boolean autenticar(String user, String pass) {
		
		String jpql="Select c From Cliente c Where c.usuario=?1 and c.password=?2";
		Query qr= em.createQuery(jpql);
		qr.setParameter(1,user);
		qr.setParameter(2,pass);
		return qr.getResultList().size()>0;
		
		/*
		boolean res=false;
		try(Connection con=Datos.getConnection("reflibros")){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
		*/
	}

	public Cliente getCliente(String user, String pass) {
		
		String jpql="Select c From Cliente c Where c.usuario=?1 and c.password=c.?2";
		Query qr= em.createQuery(jpql);
		qr.setParameter(1,user);
		qr.setParameter(2,pass);
		List<Cliente> clientes = (List<Cliente>)qr.getResultList();
		return qr.getResultList().size()>0?(Cliente)clientes.get(0):null;
	}
	
	@Override
	public void registrar(Cliente c) {
		em.persist(c);
		
/*		
		try(Connection con=Datos.getConnection("reflibros")) {                       
	           
            String sql="insert into clientes (usuario,password,email,telefono) ";
            sql+="values(?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=con.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, c.getUsuario());
               ps.setString(2, c.getPassword());
               ps.setString(3, c.getEmail());
               ps.setInt(4, c.getTelefono());
               //ejecutamos
             ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
*/		
	}

}
