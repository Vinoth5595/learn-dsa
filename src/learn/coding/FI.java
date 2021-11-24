package learn.coding;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class IronMan {
	private String suiteModel;

	public String getSuiteModel() {
		return suiteModel;
	}

	public void setSuiteModel(String suiteModel) {
		this.suiteModel = suiteModel;
	}
}

public class FI {

	public static void main(String[] args) {
		/* Functional Interfaces
		 * 
		 * 1) Function -> input and output
		 * 2) Predicate -> return boolean
		 * 3) Supplier -> no input, return output
		 * 4) Consumer -> no output
		 */
		
		Function<Integer, Integer> funcInteger = val -> val + val;
		System.out.println(funcInteger.apply(2));
		
		Predicate<Integer> isEven = val -> val % 2 == 0;
		System.out.println(isEven.test(5));
		
		Supplier<String> supplier = () -> "hello";
		System.out.println(supplier.get());
		
		IronMan ironman = new IronMan();
		Consumer<IronMan> consumer = val -> val.setSuiteModel("Model - 3");
		consumer.accept(ironman);
		System.out.println(ironman.getSuiteModel());
	}
}
