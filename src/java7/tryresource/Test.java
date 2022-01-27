package java7.tryresource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static void main(String[] args) /* 알고리즘 풀때는 : throws Exception */ {
		{ // before
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(System.in));			
				String s = br.readLine(); // Unhandled exception type IOException
			} catch(IOException ie){
				ie.printStackTrace();
			} finally {
				try { // 매우 귀찮은 작업!
					br.close();					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		{ // after : try-resource block -> auto close
			
			try(
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			) {
				String s = br.readLine(); // Unhandled exception type IOException
			} catch(IOException e){
				e.printStackTrace();
			}	
		}
		
		
	}
	
}
