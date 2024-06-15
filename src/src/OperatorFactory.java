package src;

public class OperatorFactory {
	
	public CsvSearchOperator getOperator(String operator) {
		switch (operator) {
			case "startswith":
				return new StartsWith();
	
			default:
				throw new IllegalArgumentException("Unexpected value: " + operator);
		}
	}
}
