package src;

public class StartsWith extends CsvSearchOperator {

	@Override
	public boolean test(String value, String search) {
		return value.toLowerCase().startsWith(search.toLowerCase());
	}
}
