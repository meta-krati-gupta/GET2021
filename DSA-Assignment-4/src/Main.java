public class Main {
	public static void main(String[] args) {
		EmployeeCollection ec = new EmployeeCollection();
		try{
		ec.add(new Employee(1, "Krati", "Samastipur"));
		ec.add(new Employee(2, "Khusbu", "Nalanda"));
		ec.add(new Employee(3, "Mukesh", "Samastipur"));
		ec.add(new Employee(4, "Rahul", "Rosera"));
		ec.add(new Employee(3, "Krishan", "Jaipur"));
		ec.add(new Employee(5, "Akash", "Agra"));
		}
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Initial Employee record: ");
		for (Employee e : ec.empList) {
			System.out.println(e.toString());
		}
		ec.sortNatural();
		System.out.println("After natural sort: ");
		for (Employee e : ec.empList) {
			System.out.println(e.toString());
		}
		ec.sortByName();
		System.out.println("After sorting by name: ");
		for (Employee e : ec.empList) {
			System.out.println(e.toString());
		}
	}
}




