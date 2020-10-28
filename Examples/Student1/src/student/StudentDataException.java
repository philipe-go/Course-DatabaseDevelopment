package student;

public class StudentDataException extends RuntimeException{
	private int code;
	private Object obj;
	private String msg;
	
	public StudentDataException(int code, Object obj) {
		this.code = code;
		this.obj = obj;		
		if (code==1)
			this.msg = "Invalid id: " + (int)obj;
		else if (code==2)
			this.msg = "Invalid name: " + (String)obj;
		else if (code==3)
			this.msg = "Invalid given name: " + (String)obj;
		else if (code==4)
			this.msg = "Invalid grade: " + (double)obj;
		else 
			this.msg = "Unknown exception";	
	}

	public int getCode() {
		return code;
	}

	public Object getObj() {
		return obj;
	}
    @Override
	public String getMessage() {
		return msg;
	}
	
	
	

}
