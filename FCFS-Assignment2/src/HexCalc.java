public class HexCalc implements Calc {


	private final String HexNumber;
	/**
	 * default constructor
	 */
	public HexCalc() {
		HexNumber = "0";
	}
	/**
	 * class constructor
	 * @param HexNum initialize with hexnum
	 */

	public HexCalc(String HexNum) {
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		} else {
			this.HexNumber = HexNum;
		}
	}
	/**
	 * @param hexnum
	 */
	

	public String add(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) + Integer.parseInt(HexNum, 16));
	}
	
	/**
	 * @param hexnum
	 */
	public String subtract(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) - Integer.parseInt(HexNum, 16));
	}

	
	/**
	 * @param HexNum
	 */
	public String multiply(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) * Integer.parseInt(HexNum, 16));
	}
	
	/**
	 * @param HexNum
	 */
	public String divide(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) / Integer.parseInt(HexNum, 16));
	}
	
/**
 * 
 * @param param
 * @return
 */
	public static Boolean isDecimal(String param){
		try{
			Integer.parseInt(param);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}

/**
 * 
 * @param param
 * @return
 */
	public static Boolean isHexNumber(String param){
		try{
			Integer.parseInt(param, 16);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	
             		
	/**
	 * compare two hex number,
	 * return -1 ,if less than
	 * 0,if equal
	 * 1,if greater
	 * @param hexnum
	 * @return DecNum
	 */
	public int compareTo(String HexNum) {
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		int current = Integer.parseInt(HexNumber,16);
		int other = Integer.parseInt(HexNum, 16);
		if(current > other){
			return 1;
		}
		else if(current < other){
			return -1;
		}
		return 0;
}

}

