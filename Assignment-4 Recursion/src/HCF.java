public class HCF {
	/**
	 * calculate hcf of x and y
	 * @param x
	 * @param y
	 * @return hcf of two numbers.
	 */
	public static int hcf(int x,int y)
	{
		if(x==0)
			return y;
		return hcf(y%x,x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 15;
		
		System.out.println("HCF of " + x + " and " + y + " is " + hcf(x,y));
		
	}

	}

