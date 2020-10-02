package student;

//"extends" is creating a parent : child relationship
public class StudentDataException extends RuntimeException{
	private int code;
	private Object obj;
	private String msg;
	
	public StudentDataException(int code, Object obj) {
		this.code = code;
		this.obj = obj;
		
		if (code ==1)
			this.msg = "Invalid id: " + (int) obj;
		else if (code == 2)
			this.msg = "Invalid name: "+ (String) obj;
		else if (code == 3)
			this.msg = "Invalid given name: "+(String) obj;
		else if (code == 4)
			this.msg = "Invalid grade: "+ (double) obj;
		else
			this.msg = "Unkown exception";
	}
	
	public int GetCode()
	{
		return code;
	}
	
	public Object GetObj()
	{
		return obj;
	}
	
	//@Override overrides the method from the parent class
	@Override
	public String getMessage()
	{
		return msg;
	}

}
