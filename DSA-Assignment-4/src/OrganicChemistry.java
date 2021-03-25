public class OrganicChemistry {
	private final static int C_MASS = 12;
	private final static int H_MASS = 1;
	private final static int O_MASS = 16;


	/**
	 * Calculates molecular mass
	 * @param formula
	 */
	private static int calcMolecularMass(String formula){
		// checking if formula is null
		if (formula == null) {
			throw new NullPointerException("Chemical formula can't be null");
		}

		// checking if formula is empty
		if (formula.length() == 0) {
			throw new IllegalArgumentException("Chemical formula can't be empty");
		}

		int index=0, mass=0;
		while (index < formula.length()){
			char ch = formula.charAt(index);
			if (ch == '('){
				index++;
				int num=0;
				String tempFormula = "";
				//recursive call for inner compound
				while (formula.charAt(index) != ')'){
					tempFormula += formula.charAt(index);
					index++;
				}
				index++;
				//get number of compound chain
				if(Character.isDigit(formula.charAt(index))){
	                //Entry is Digit, it could be greater than one digit number
					char temp = formula.charAt(index);
					while (Character.isDigit(temp)) {
	                    num = num*10 + (temp-'0');
	                    index++;
	                    if(index < formula.length()){
	                        temp = formula.charAt(index);
	                    }
	                    else{
	                        break;
	                    }
	                }
	                index--;
				}
				mass += calcMolecularMass(tempFormula)*num;
			}

			if (ch == 'c' || ch=='C'){
				if (index+1 < formula.length() && Character.isDigit(formula.charAt(index+1))){
					index++;
					int num = 0;
					char temp = formula.charAt(index);
	                //Entry is Digit, it could be greater than one digit number
					while (Character.isDigit(temp)) {
	                    num = num*10 + (temp-'0');
	                    index++;
	                    if(index < formula.length()){
	                        temp = formula.charAt(index);
	                    }
	                    else{
	                        break;
	                    }
	                }
	                index--;
					mass += num*C_MASS;
				}
				else{
					mass += C_MASS;
				}
			}
			else if (ch == 'h' || ch=='H'){
				if (index+1 < formula.length() && Character.isDigit(formula.charAt(index+1))){
					index++;
					int num = 0;
					char temp = formula.charAt(index);
	                //Entry is Digit, it could be greater than one digit number
					while (Character.isDigit(temp)) {
	                    num = num*10 + (temp-'0');
	                    index++;
	                    if(index < formula.length()){
	                        temp = formula.charAt(index);
	                    }
	                    else{
	                        break;
	                    }
	                }
	                index--;
					mass += num*H_MASS;
				}
				else{
					mass += H_MASS;
				}
			}
			else if (ch == 'o' || ch=='O'){
				if (index+1 < formula.length() && Character.isDigit(formula.charAt(index+1))){
					index++;
					int num = 0;
					char temp = formula.charAt(index);
	                //Entry is Digit, it could be greater than one digit number
					while (Character.isDigit(temp)) {
	                    num = num*10 + (temp-'0');
	                    index++;
	                    if(index < formula.length()){
	                        temp = formula.charAt(index);
	                    }
	                    else{
	                        break;
	                    }
	                }
	                index--;
					mass += num*O_MASS;
				}
				else{
					mass += O_MASS;
				}
			}
			index++;
		}
		return mass;
	}


	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		String nul = null;
		String emp = "";
		String s = "c6h12o6";			//Monosacchride glucose
		String s1 = "ch3(ch2)2ch3";		//Butane
		String s2 = "ch3(ch2)2cooh";	//butanoic acid
		try{
			System.out.println("Molecular Weight of "+nul+" is: "+ calcMolecularMass(nul));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		try{
			System.out.println("Molecular Weight of "+emp+" is: "+ calcMolecularMass(emp));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Molecular Weight of "+s+" is: "+ calcMolecularMass(s));
		System.out.println("Molecular Weight of "+s1+" is: "+ calcMolecularMass(s1));
		System.out.println("Molecular Weight of "+s2+" is: "+ calcMolecularMass(s2));
	}
}



