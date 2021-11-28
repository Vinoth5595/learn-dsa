package learn.design.pattens;

// Eagerly initialized singleton pattern
class SimpleSingleton {
	private static final SimpleSingleton simpleSingleton = new SimpleSingleton();
	
	private SimpleSingleton() {
		if (simpleSingleton != null) throw new IllegalStateException("Singleton already intialized!!!");
	}
	
	public static SimpleSingleton getInstance() {
		return simpleSingleton;
	}
}

// Eagerly Initialized static block singleton
class StaticBlockSingleton {
	private static final StaticBlockSingleton sbc;
	
	private StaticBlockSingleton() {}
	
	static {
		sbc = new StaticBlockSingleton();
	}
	
	public static StaticBlockSingleton getInstance() {
		return sbc;
	}
}

// Lazy Initialization singleton
class LazySingleton {
	private static LazySingleton lazySingleton;
	
	private LazySingleton() {}
	
	public static synchronized LazySingleton getInstance() {
		if(lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		
		return lazySingleton;
	}
}

public class Singleton {

	public static void main(String[] args) {
		System.out.println(SimpleSingleton.getInstance().hashCode() + " " + SimpleSingleton.getInstance().hashCode());
		System.out.println(StaticBlockSingleton.getInstance().hashCode() + " " + StaticBlockSingleton.getInstance().hashCode());
		System.out.println(LazySingleton.getInstance().hashCode() + " " + LazySingleton.getInstance().hashCode());
	}

}
