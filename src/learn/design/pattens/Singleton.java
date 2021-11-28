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

public class Singleton {

	public static void main(String[] args) {
		System.out.println(SimpleSingleton.getInstance().hashCode() + " " + SimpleSingleton.getInstance().hashCode());
	}

}
