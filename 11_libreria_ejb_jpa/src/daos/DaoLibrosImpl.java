/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Libro;
import model.Tema;

@Stateless
 public class DaoLibrosImpl implements DaoLibros {
	 
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;    
    @Override
	public List<Libro> recuperarLibros(){
    	Query qr= em.createNamedQuery("Libro.findAll");
    	return (List<Libro>)qr.getResultList();

    	
    	
/*    	List<Libro> lista=new ArrayList<> ();
        try(Connection con=Datos.getConnection("reflibros")) {                       
        	String sql="select * from libros";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
*/ 
    }
    @Override
	public List<Libro> recuperarLibros(int idTema){

    	// 1ª forma usual
/*    	
		String jpql="Select l From Libro l Where l.tema.idTema=?1";
		Query qr= em.createQuery(jpql);
		qr.setParameter(1,idTema);
		return (List<Libro>)qr.getResultList();
*/		
    	// 2ª Forma
    	Tema tm=em.find(Tema.class, idTema);
    	return tm.getLibros();

/*    	List<Libro> lista=new ArrayList<> ();
        try(Connection con=Datos.getConnection("reflibros")) {                       
        	String sql="select * from libros where idTema=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, idTema);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
*/
    }
    
    
}
