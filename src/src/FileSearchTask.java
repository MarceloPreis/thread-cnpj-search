package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class FileSearchTask implements Runnable {
	
	private String searchableClass;
	private String filePath;
	private JsonResponse response;
	private CsvSearch search;
	
	
	FileSearchTask(String searchableClass, String filePath, CsvSearch search, JsonResponse reponse) {
		this.searchableClass = searchableClass;
		this.filePath = filePath;
		this.search = search;
		this.response = reponse;
	}
	
	@Override
	public void run() {
		try {
			SearchableFactory searchableFactory = new SearchableFactory();
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
                      
            System.out.println(filePath);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();                        

                Searchable searchable = searchableFactory.create(this.searchableClass);
                searchable.fill(line.split(";"));                
                
                if (search.test(searchable)) {
                	this.response.add(searchable);
                }
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
