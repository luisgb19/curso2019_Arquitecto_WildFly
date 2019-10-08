package daos;

import java.util.List;

import model.Venta;

public interface DaoVentas {
	
	List<Venta> obtenerVentas(String idCliente);

}
