package pack;

import java.util.Comparator;

public class SalarySorter implements Comparator<Employee>{
	
	public SalarySorter() {}
	
	@Override
	public int compare(Employee e1, Employee e2)
	{
		int i = e1.Get_salary() > e2.Get_salary() ? 1 : 
					e1.Get_salary() == e2.Get_salary() ? 0 : -1;
		if (i == 0) i = e1.Get_id() - e2.Get_id();
		return i;
	}

}
