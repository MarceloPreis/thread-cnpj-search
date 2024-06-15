package src;

import java.lang.reflect.Field;

public class CsvSearch {
	String column;
	String searchValue;
	CsvSearchOperator operator;
	
	public CsvSearch(String column, String searchValue, String operator) {
		super();
		this.column = column;
		this.searchValue = searchValue;
		
		OperatorFactory factory = new OperatorFactory();
		this.operator = factory.getOperator(operator);
	}
	
	public boolean test(Searchable object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Field field = object.getField(this.column);
		field.setAccessible(true);
		String value = field.get(object).toString();
		
		return this.operator.test(value, this.searchValue);
	}
}
