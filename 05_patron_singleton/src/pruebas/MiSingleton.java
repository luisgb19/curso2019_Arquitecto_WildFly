package pruebas;
//implementación del patrón Singleton
public class MiSingleton {

	private static MiSingleton obj;
	
	static {
		obj = new MiSingleton();
	}
	
	private MiSingleton() {
		
	}

	public static MiSingleton getMiSingleton() {
		return obj;
	}
}
