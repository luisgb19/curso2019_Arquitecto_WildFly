package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Contacto;

/**
 * Session Bean implementation class DaoContactosImpl
 */
@Stateless
public class DaoContactosImpl implements DaoContactos {

	@PersistenceContext(unitName="agendaPU")
	EntityManager em;
	@Override
	
	public void eliminarContacto(int id) {
		Contacto contacto=em.find(Contacto.class, id);
		if(contacto!=null) {
			em.remove(contacto);
		}
		
	}

	@Override
	public List<Contacto> recuperarContactos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altaContacto(Contacto contacto) {
		em.persist(contacto);
		
	}

   

}
