import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld1 
{
    public static void main (String[] args) throws IOException
    {
        //in case the inputStreamReader gives error we handle the exception as above 
      System.out.println("Hello World");
      System.out.print("Hello");
      System.out.print(" World \n");
      
      InputStreamReader r = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(r);

      System.out.print("Enter your name: ");
      String name = br.readLine();

      System.out.println("Welcome "+name);
    }
}
