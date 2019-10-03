package daos;

import java.util.List;

import javax.ejb.Local;

import model.Contacto;

@Local
public interface DaoContactos {

	void eliminarContacto(Integer id);

	List<Contacto> mostrarContactos();

	void altaContacto(Contacto contacto);

	void altaContacto();

}
