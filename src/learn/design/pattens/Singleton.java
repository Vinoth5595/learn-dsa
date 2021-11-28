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

public class Singleton {

	public static void main(String[] args) {
		System.out.println(SimpleSingleton.getInstance().hashCode() + " " + SimpleSingleton.getInstance().hashCode());
		System.out.println(StaticBlockSingleton.getInstance().hashCode() + " " + StaticBlockSingleton.getInstance().hashCode());
	}

}
