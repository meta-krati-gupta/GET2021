public interface Calc {
	/**
	 * add two numbers
	 * @param Num
	 * @return number results of addition
	 */
	public abstract String add(String Num);
	
	/**
	 * subtract number
	 * @param Num
	 * @return number result of subtraction
	 */
	 public abstract String subtract(String Num);
	 /**
		 * multiply number
		 * @param Num
		 * @return number result of multiplication
		 */
	 
	 
	  public abstract String multiply(String Num);
	  /**
		 * divide number
		 * @param Num
		 * @return number result of division
		 */
	  
	  
	  public abstract String divide(String Num);
	  
	  /**
		 * compare two number and return
		 * -1,if less than
		 * 0,if equal
		 * 1,if greater than
		 * @param Num
		 * @return number 
		 */
	  
	  public int compareTo(String Num);
	  
}
