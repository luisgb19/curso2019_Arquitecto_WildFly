package ejbs;

import java.util.concurrent.Future;

import javax.ejb.Local;

@Local
public interface Calculo {
	Future<Integer> sumaNumeros(int n);
}
