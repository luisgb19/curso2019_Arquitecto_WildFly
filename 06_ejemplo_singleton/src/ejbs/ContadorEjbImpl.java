package ejbs;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class ContadorEjbImpl
 */
@Singleton
public class ContadorEjbImpl implements ContadorEjb {

	private int valor=0;
	@Override
	public void incrementar() {
		valor++;
		int sum = valor;
		System.out.println("LGB --- ContadorEjbImpl incrementar() valor = "+sum);
	}

	@Override
	public void decrementar() {
		valor--;
	}

	@Override
	public int getValor() {
		int sum = valor;
		System.out.println("LGB --- ContadorEjbImpl getValor() valor = "+sum);
		return valor;
	}


}
