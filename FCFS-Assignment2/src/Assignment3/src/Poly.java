import java.util.Arrays;

public class Poly {

	private final double[] coefficient;
	private final double[] exponent;
   /**
    * 
    * @param coefficient
    * @param exponent
    */

	public Poly(double[] coefficient, double[] exponent) {
		this.coefficient = coefficient;
		this.exponent = exponent;
	}
  /**
   * 
   * @return the coefficient
   */

	public double[] getCoefficient() {
		return coefficient;
	}
	/**
	 * 
	 * @return the exponent
	 */


	public double[] getExponent() {
		return exponent;
	}

   /**
    * 
    * @param value
    * @return the value of polynomial for given value of variable
    */
	public float evaluate(float value){
		float res = 0;
		for (int i = 0; i < coefficient.length; i++) {
			res += coefficient[i] * Math.pow(value, exponent[i]);
		}
		return res;
	}
  /**
   * 
   * @return the degree of polynomial
   */

	public double getDegree(){
		double max = exponent[0];
		for (int i = 1; i < exponent.length; i++) {
			if(max > exponent[i]){
				max = exponent[i];
			}
		}
		return max;
	}

  /**
   * 
   * @param p1
   * @param p2
   * @return  the sum of polynomial p1 and p2
   */
	public static Poly addPoly(Poly p1, Poly p2){
		int lenP1 = p1.getCoefficient().length;
		int lenP2 = p2.getCoefficient().length;
		int maxLen = lenP1>lenP2?lenP1:lenP2;
		double[] coeff = new double[maxLen];
		double[] exp = new double[maxLen];
		Poly add = new Poly(coeff, exp);
		for (int i = 0; i < p1.exponent.length; i++) {
			for (int j = 0; j < p2.exponent.length; j++) {
				if(p1.exponent[i] == p2.exponent[j]){
					add.coefficient[i] = p1.coefficient[i] + p2.coefficient[j];
					add.exponent[i] = p1.exponent[j];
				}
			}
		}
		return add;
	}

	
	/**
	 * 
	 * @param p1
	 * @param p2
	 * @return product of polynomial p1 and p2
	 */
	public static Poly	multiplyPoly(Poly p1, Poly p2){
		int lenP1 = p1.getCoefficient().length;
		int lenP2 = p2.getCoefficient().length;
		double[] coeff = new double[lenP1*lenP2];
		double[] exp = new double[lenP1*lenP2];
		
		Poly mul = new Poly(coeff, exp);
		for (int i = 0; i < p1.coefficient.length; i++) {
			for (int j = 0; j < p2.coefficient.length; j++) {
				mul.coefficient[i] = p1.coefficient[i] * p2.coefficient[j];
				mul.exponent[i] = p1.exponent[i] * p2.exponent[j];
			}
		}
		return mul;
	}


}

	
