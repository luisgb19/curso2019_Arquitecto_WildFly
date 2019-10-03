package modelo;

import java.util.List;

import javax.ejb.Local;

import beans.Producto;

@Local
public interface CarritoEJB {

	void agregar(Producto p);
	void eliminar(int pos);
	List<Producto> recuperarCarrito();
}
