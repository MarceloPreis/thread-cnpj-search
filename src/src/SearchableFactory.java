package src;

public class SearchableFactory {
	
	public Searchable create(String seachable) {
		switch (seachable) {
			case "company":
				return new Company();
	
			default:
				throw new IllegalArgumentException("Unexpected value: " + seachable);
		}
	}
}
