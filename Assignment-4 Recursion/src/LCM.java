import java.util.Scanner;
public class LCM {   
   /**
    * recursive method to return gcd of x and y
    * @param x
    * @param y
    * @return gcd of x and y.
    */
	static int gcd(int x, int y)
    {
 	if(x==0)
 		return y;
 	return gcd(y%x,x);
    }
    
	/**
	 * method to return lcm of two numbers.
	 * @param x
	 * @param y
	 * @return lcm
	 */
    static int lcm(int x, int y)
    {
 	return (x / gcd(x,y))*y;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,ans=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st no");
		x = sc.nextInt();
		System.out.println("Enter 2st no");
		y = sc.nextInt();
		
		ans = lcm(x,y);
		
		System.out.println("LCM of " + x + " and " + y + " is " + ans);
		}


}
