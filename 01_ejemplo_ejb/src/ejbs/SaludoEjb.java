package ejbs;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludoEjb
 */
@Stateless
public class SaludoEjb implements SaludoEjbLocal {

    /**
     * Default constructor. 
     */
	@Override
	public String getSaludo(String nombre) {
		return "Bienvenido a mi EJB " + nombre;
    }

}
