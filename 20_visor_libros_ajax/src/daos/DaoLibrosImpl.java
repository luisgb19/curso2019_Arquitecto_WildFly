package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Libro;
import model.Tema;

/**
 * Session Bean implementation class DaoLibrosImpl
 */
@Stateless
public class DaoLibrosImpl implements DaoLibros {

	@PersistenceContext(unitName="librosPU")
	EntityManager em;
	@Override
	public List<Libro> librosPorTema(int idTema) {
		Tema tema=em.find(Tema.class, idTema);
		return tema.getLibros();
	}

}
