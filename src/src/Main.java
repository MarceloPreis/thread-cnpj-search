package src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
        long start = System.currentTimeMillis();

		FileManager fileManager = new FileManager("./cnpj-files").scanDir();
		ExecutorService executor = Executors.newFixedThreadPool(fileManager.fileCount());
		JsonResponse response = new JsonResponse();
		CsvSearch search = new CsvSearch("razao_social", "HU", "startswith");		
		
		for (String filePath : fileManager.getFiles())
			executor.execute(new FileSearchTask("company", filePath, search, response));
		
        try {
        	
        	if (!executor.awaitTermination(180, TimeUnit.SECONDS)) {
                executor.shutdownNow(); 
            }
        	
        	long end = System.currentTimeMillis();
        	System.out.println((start - end) / 1000);
        	System.out.println(response.data.toString());
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
		
	}
}