package pack;

import java.util.Comparator;

public class NameSorter implements Comparator<Employee> {
	public NameSorter() {}
	
	@Override
	public int compare(Employee e1, Employee e2)
	{
		int i = e1.Get_name().compareTo(e2.Get_name());
		if (i == 0) i = e1.Get_givenName().compareTo(e2.Get_givenName());
		if (i == 0) i = e1.Get_id()-e2.Get_id();
		return i;
	}
}
