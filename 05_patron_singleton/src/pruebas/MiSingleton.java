package pruebas;
//implementaci�n del patr�n Singleton
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
