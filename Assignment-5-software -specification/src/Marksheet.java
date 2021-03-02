import java.util.Scanner;
import java.util.InputMismatchException;

public class Marksheet {
                 
	          double average(double[] grades)
                  {
                	  double total = 0;
                	  for(double i:grades)
                	  {
                		  total += i;
                	  }
                	  return total/grades.length;
                  }
              
	          
	          double maxGrade(double[] grades)
	          {
	        	  double maxGrade=grades[0];
	        	  for(double i:grades)
	        	  {
	        		  if(i>maxGrade)
	        			  maxGrade = i;
	        	  }
	        	  return maxGrade;
	          }
	          
	          
	          double minGrade(double[] grades)
	          {
	        	  double minGrade=grades[0];
	        	  for(double i:grades)
	        	  {
	        		  if(i<minGrade)
	        			  minGrade = i;
	        	  }
	        	  return minGrade;
	          }
	          
	          
	          double percentPass(double[] grades)
	          {
	        	  double percent;
	        	  double noOfPassed=0;
	        	  for(double i:grades)
	        	  {  
	        		  System.out.println(i);
	        		  if(i>=40)
	        		  {
	        			  noOfPassed++;
	        		  }
	        			  
	        	  }
	        	  percent = ((double)(noOfPassed/grades.length))*100;
	        	  return percent;
	          }

                  
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int noOfStudents = 0;
		Marksheet ms = new Marksheet();
		System.out.println("Enter no of student");
		Scanner sc = new Scanner(System.in);
		int flag =0;
		while(flag==0)
		{
			try
			{
				noOfStudents = sc.nextInt();
				flag=1;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter valid input");
				System.exit(0);
			}
		}
		System.out.println("Enter the grades of student");
		double grades[] = new double[noOfStudents];
		
		for(int i=0;i<noOfStudents;i++)
		{
			grades[i]=sc.nextDouble();
		}
        System.out.println("Average Of All Students Is " +ms.average(grades));
        System.out.println("Maximum Grade Is " +ms.maxGrade(grades));
        System.out.println("Minimum Grade Is " +ms.minGrade(grades));
        System.out.println("Percentage Of Students Passed " +ms.percentPass(grades));
        sc.close();
        
        
        
        
	}

}
