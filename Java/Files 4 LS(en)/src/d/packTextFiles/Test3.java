package d.packTextFiles;

import java.io.*;

public class Test3 {

	public static void main(String[] args) throws IOException {
		PrintWriter w =new PrintWriter (new FileWriter("mytext3.txt"));
		w.println("Montreal\nQuebec");
		w.println("Montreal\rQuebec");
		w.println("Montreal\r\nQuebec");
		w.println("Montreal\n\nQuebec");
		w.println("Montreal\n\rQuebec");
		w.close();
	}

}
