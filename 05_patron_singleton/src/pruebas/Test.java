package pruebas;
// implementación del patrón Singleton
public class Test {

	public static void main(String[] args) {
		MiSingleton a = MiSingleton.getMiSingleton();
		MiSingleton b = MiSingleton.getMiSingleton();
		MiSingleton c = MiSingleton.getMiSingleton();
		System.out.println("a="+a.hashCode());
		System.out.println("b="+b.hashCode());
		System.out.println("c="+c.hashCode());
				
	}

}
