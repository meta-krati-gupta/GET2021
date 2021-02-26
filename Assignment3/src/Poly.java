import java.util.Arrays;

public class Poly {

	private final double[] coefficient;
	private final double[] exponent;


	public Poly(double[] coefficient, double[] exponent) {
		this.coefficient = coefficient;
		this.exponent = exponent;
	}


	public double[] getCoefficient() {
		return coefficient;
	}


	public double[] getExponent() {
		return exponent;
	}


	public float evaluate(float value){
		float res = 0;
		for (int i = 0; i < coefficient.length; i++) {
			res += coefficient[i] * Math.pow(value, exponent[i]);
		}
		return res;
	}


	public double getDegree(){
		double max = exponent[0];
		for (int i = 1; i < exponent.length; i++) {
			if(max > exponent[i]){
				max = exponent[i];
			}
		}
		return max;
	}


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


//}

	public static void main(String[] args) {
		System.out.println("Poly Test: ");
		Poly p1 = new Poly(new double[]{2,3,5}, new double[]{2,1});
		Poly p2 = new Poly(new double[]{3,5} , new double[]{2,1});
		Poly add = Poly.addPoly(p1,p2);
		Poly mul = Poly.multiplyPoly(p1,p2);
		System.out.println(p1.evaluate(4));
		
		System.out.println(Arrays.toString(add.getCoefficient())+ "\n" 
		             + Arrays.toString(add.getExponent()));
		
		System.out.println(Arrays.toString(mul.getCoefficient())+ "\n" 
	             + Arrays.toString(mul.getExponent()));
		
		
		System.out.println("IntSet Test: ");
		IntSet intset1 = new IntSet(new int[]{1,2,3,4,6});
		IntSet intset2 = new IntSet(new int[]{3,5,6});
		System.out.println(Arrays.toString(intset1.getComplement()));
		System.out.println(Arrays.toString(intset1.union(intset2)));
		System.out.println(intset1.isSubSet(intset2));
		System.out.println(intset1.isMember(3));
		
		
		// TODO Auto-generated method stub

	}

}
