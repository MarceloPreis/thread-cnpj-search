package src;



public class Searchable {

	@SuppressWarnings("unchecked")
	public <T> T getField(String attrName) throws NoSuchFieldException, SecurityException {
		return (T) this.getClass().getDeclaredField(attrName);
	}
	
	public void fill(String[] attrs) {
		return;
	}
}
