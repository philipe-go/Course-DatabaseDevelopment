package c.testTextFiles;

import java.io.*;

public class Test2TextFile {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter w =new BufferedWriter (new FileWriter("test2.txt"));  // rewrite mode
	    w.write("aaa aaa aaa");
	    w.newLine();
	    w.write("AA AA AA");
	    w.newLine();
	    w.close();
	    
	    w =new BufferedWriter (new FileWriter("test2.txt",true));    // append mode
	    w.write("bbb bbb bbb");
	    w.newLine();
	    w.close();	    
	    
	}
}
