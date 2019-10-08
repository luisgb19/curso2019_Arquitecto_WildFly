package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Venta;

public class DaoVentasImpl implements DaoVentas {

	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	

	@Override
	public List<Venta> obtenerVentas(String idCliente) {
		String jpql="Select v From Venta v, Cliente c Where v.idCliente=?1 and v.idCliente=c.idCliente";
		Query qr= em.createQuery(jpql);
		qr.setParameter(1,idCliente);
		return (List<Venta>)qr.getResultList();

	}

}
