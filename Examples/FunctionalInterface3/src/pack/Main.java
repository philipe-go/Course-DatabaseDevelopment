package pack;

public class Main {

	public static void main(String[] args) {

       MyGreeting m1= new MyGreeting();
       
       System.out.println(m1.msg("John"));
       
       GreetingMsg m1a = new MyGreeting();   
       
       System.out.println(m1a.msg("Jean"));  
 
//==================================================================
       
       GreetingMsg m2 = new GreetingMsg() {
    	   @Override
    	   public String msg(String name) {
    		   return "Hi, "+ name+". I am constructed directly from the interface.";
    	   }
       };
       System.out.println(m2.msg("Mary"));
       
       System.out.println(new GreetingMsg() {
    	   @Override
    	   public String msg(String name) {
    		   return "Hi, "+ name+". I am constructed directly from the interface, by both anonymous class and object";
    	   }
       }.msg("Mary")   
       );

//==================================================================
       
       // Only for functional interfaces (interfaces with only ONE method to be
       // overridden).
       
       GreetingMsg m3 = (name)-> "Hi,"+ name+". I am constructed directly from the interface, using a lambda function.";
    	  
       System.out.println(m3.msg("Mary"));
       
       System.out.println(
    		   ((GreetingMsg)(name)-> "Hi,"+ name+". I am constructed directly from the interface, using a lambda function and anonymous object.")
    		   .msg("Mary")
    		   );
       
       // the objects in m1 and in m1a are of the type MyGreeting 
       // the objects in m2 and m3 are of anonymous type (anonymous class)
       System.out.println();
       System.out.println("The type of the interface is " + GreetingMsg.class);   // the type of the interface itself 
       System.out.println("The type of m1 is " + m1.getClass());
       System.out.println("The type of m1a is " + m1a.getClass());
       System.out.println("The type of m2 is " + m2.getClass());
       System.out.println("The type of m3 is " + m3.getClass()); 
      
	}
}
