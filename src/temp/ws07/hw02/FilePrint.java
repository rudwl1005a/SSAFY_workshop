package temp.ws07.hw02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FilePrint extends PrintProcess {
	
	@Override
	public void print(double weightAve, double tallAve) throws Exception {
		String file = "C:\\outtest1.txt";
		OutputStream os = new FileOutputStream(file);
		
	}
}
