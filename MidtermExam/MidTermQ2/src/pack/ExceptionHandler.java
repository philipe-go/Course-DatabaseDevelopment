package pack;

public class ExceptionHandler extends RuntimeException {
	private int _code;
	private Object _obj;
	private String _msg;
	
	public ExceptionHandler(int c, Object o)
	{
		this._code = c;
		this._obj = o;
		switch (_code)
		{
			case 1: this._msg = "Invalid id (id less or equal to zero) "+ (int)o; break;
			case 2: this._msg = "Invalid name "+ (String)o; break;
			case 3: this._msg = "Invalid given name "+ (String)o; break;
			case 4: this._msg = "Invalid salary (salary less then zero "+ (double)o + ")"; break;
			default: this._msg = "Unknown Exception "; break;
		}
	}
	
	public int Get_Code() { return _code; }
	public Object Get_Obj() { return _obj; }
	
	@Override
	public String getMessage() { return _msg; }
}
