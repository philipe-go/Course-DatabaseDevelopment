package c.testTextFiles;

import java.io.*;

public class Test3TextFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PrintWriter w =new PrintWriter( new BufferedWriter (new FileWriter("test3.txt")));	// rewrite mode	
	    w.write("aaa aaa aaa aaa");
	    w.println();
	    w.println("AA AA AA AA");
	    w.print("AAAAA AAA");
	    w.println();	   
	    w.close();
	    
	    w =new PrintWriter( new BufferedWriter (new FileWriter("test3.txt",true)));  // append mode
	    w.write("bbb bbb bbb bbb");
	    w.println();
	    w.close();
	}
}
