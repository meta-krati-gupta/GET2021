import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeCollection {
	List<Employee> empList;

	/**
	 * Constructor
	 */
	public EmployeeCollection() {
		empList = new ArrayList<Employee>();
	}

	/**
	 * @param arg0
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean add(Employee emp) {
		if(this.contains(emp)){
			throw new IllegalArgumentException("Employee already exist in collection: "+emp.getEmpId()+"/"+emp.getName());
		}
		return empList.add(emp);
	}

	/**
	 * @param emp
	 * @return
	 */
	public boolean contains(Employee emp) {
		for (Employee e : empList) {
			if(e.getEmpId() == emp.getEmpId()){
				return true;
			}
		}
		return false;
	}

	/**
	 * @param emp
	 * @return
	 */
	public boolean remove(Employee emp) {
		return empList.remove(emp);
	}

	/**
	 * @return size of the Employee collection
	 */
	public int size() {
		return empList.size();
	}
	/**
	 * This  function sorts employee list based on their ID.
	 */
	public void sortNatural(){
		Collections.sort(empList ,new Comparator<Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				if(arg0.getEmpId()>arg1.getEmpId()){
					return 1;
				} else {
					return -1;
				}
			}
		});
	}
	
	/**
	 * This  function sorts object list based on Employee names in Ascending order.
	 */
	public void sortByName(){
		Collections.sort(empList ,new Comparator<Employee>() {
			@Override
			public int compare(Employee arg0, Employee arg1) {
				return arg0.getName().compareToIgnoreCase(arg1.getName());
			}
		});
	}
}

