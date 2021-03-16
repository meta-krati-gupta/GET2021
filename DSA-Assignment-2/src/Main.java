//package counselling;

import java.io.IOException;


public class Main {

	
	public static void main(String[] args) throws IOException{
		Counselling counselling = new Counselling();
		
		counselling.readFile("student.xlsx", "college.xlsx");
		//counselling.readFile("C:\\Users\\krati.gupta_metacube\\Desktop", "C:\\Users\\krati.gupta_metacube\\Desktop");

		counselling.intializePrograms();		
		counselling.allocate();
		counselling.save();
		
	}
}

