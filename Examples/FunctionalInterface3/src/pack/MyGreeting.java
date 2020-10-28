package pack;

public class MyGreeting implements GreetingMsg{

	@Override
	public String msg( String name ) {
		
		return "Hello, " + name+ ". I am the usual way to implement an interface.";
	}

	
}
