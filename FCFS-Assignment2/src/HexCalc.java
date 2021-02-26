public interface Calc {
	  public abstract String add(String Num);
	  public abstract String subtract(String Num);
	  public abstract String multiply(String Num);
	  public abstract String divide(String Num);
	  public int compareTo(String Num);
}
public class HexCalc implements Calc {

	private final String HexNumber;
	public HexCalc() {
		HexNumber = "0";
	}

	public HexCalc(String HexNum) {
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		} else {
			this.HexNumber = HexNum;
		}
	}
	

	public String add(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) + Integer.parseInt(HexNum, 16));
	}
	
	
	public String subtract(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) - Integer.parseInt(HexNum, 16));
	}

	
	
	public String multiply(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) * Integer.parseInt(HexNum, 16));
	}
	
	
	public String divide(String HexNum){
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		return Integer.toHexString(Integer.parseInt(HexNumber, 16) / Integer.parseInt(HexNum, 16));
	}
	

	public static Boolean isDecimal(String param){
		try{
			Integer.parseInt(param);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}


	public static Boolean isHexNumber(String param){
		try{
			Integer.parseInt(param, 16);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	

	public static int HexToDec(String HexNum) {
		if(!isHexNumber(HexNum)){
			throw new NumberFormatException("Not Hex Number: " + HexNum);
		}
		int DecNum = Integer.parseInt(HexNum,16);
		return DecNum;
	}
	

	public static String DecToHex(String DecNum) {
		String HexNum = Integer.toHexString(Integer.parseInt(DecNum, 16)).toUpperCase();
		return HexNum;
	}
	
	
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
//}

public static void main(String args[]){
	String x = "174";
	HexCalc hc = new HexCalc(x);
	System.out.println(hc.add("ab"));
	System.out.println(hc.multiply("a1"));
	System.out.println(hc.compareTo("68"));
	System.out.println(HexCalc.HexToDec("ab"));
	System.out.println(HexCalc.DecToHex("19"));
	System.out.println(HexCalc.isHexNumber("jh"));
	
	}
		
	}