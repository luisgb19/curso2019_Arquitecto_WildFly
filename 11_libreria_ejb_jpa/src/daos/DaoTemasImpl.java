/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Tema;

@Stateless
 public class DaoTemasImpl implements DaoTemas {
	 
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
    @Override
	public List<Tema> obtenerTemas(){
    	Query qr= em.createNamedQuery("Tema.findAll");
    	return (List<Tema>)qr.getResultList();
    	
    	
/*    	
    	List<Tema> lista=new ArrayList<> ();
        try(Connection con=Datos.getConnection("reflibros")) {                       
            //Paso 2: Envio SQL
            String sql="select * from temas";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
*/        
    }

    // Utilización de join explícito
	@Override
	public Tema obtenerTemaDeLibro(String titulo) {
		String jpql="Select t From Tema t join t.libros l Where l.titulos=?1";
		Query qr= em.createQuery(jpql);
		qr.setParameter(1,titulo);
		Tema tm=null;
		try {
			tm=(Tema)qr.getSingleResult();
		}catch (NonUniqueResultException e) {
			e.printStackTrace();
		}
		return tm; 
	}

    
}
