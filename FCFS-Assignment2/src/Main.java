
public class Main {

 
public static void main(String[] args){
	String x = "173";
	HexCalc hc = new HexCalc(x);
	System.out.println(hc.add("ab"));
	System.out.println(hc.multiply("a1"));
	System.out.println(hc.compareTo("68"));
	System.out.println(HexCalc.isHexNumber("jh"));
	
	}
		
	}