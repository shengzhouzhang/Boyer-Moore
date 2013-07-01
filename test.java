import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		
		final String pattern = "Returns an int value with at most a single one-bit, in the position of the highest-order (leftmost) one-bit in the specified int value.";
		BufferedReader reader;
		StringBuilder buffer;
		String line;
		
		try {
			
			// read content
			reader = new BufferedReader(new FileReader("/Users/szhang/Documents/wiki/test.txt"));
			buffer = new StringBuilder();
			
			line = reader.readLine();
			
			while (line != null) {
				
				buffer.append(line);
				line = reader.readLine();
			}
			
			BM_CMP test = new BM_CMP();
			
			// find pattern
			long startTime = System.currentTimeMillis();
			int resultA = test.find(buffer.toString(), pattern);
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) / 1000.0);
			
			startTime = System.currentTimeMillis();
			int resultB = buffer.toString().indexOf(pattern);
			endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) / 1000.0);
			
			System.out.println(resultA + " : " + resultB);
			
			assert resultA == resultB;
			
			// finish
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
