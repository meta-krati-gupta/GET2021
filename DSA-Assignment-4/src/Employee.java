public class Employee {
	private final int empId;
	private String name, address;
	
	
	/**
	 * Constructor
	 * @param empId
	 * @param name
	 * @param address
	 */
	public Employee(int id, String name, String address) {
		this.empId = id;
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return empId+"\t"+name+"\t"+address;
	}
	
	
	
}
