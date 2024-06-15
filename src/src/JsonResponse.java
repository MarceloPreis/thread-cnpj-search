package src;

import java.util.ArrayList;

public class JsonResponse {
	ArrayList<Searchable> data = new ArrayList<Searchable>();
	
	public synchronized void add(Searchable item) {
		this.data.add(item);
	}
}
