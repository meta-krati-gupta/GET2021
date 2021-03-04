import java.util.Scanner;
import java.lang.Math;
public class HexDec {

        // Function to convert hexadecimal to decimal 
   static int hexadecimalToDecimal(String hexVal) 
       {    
            int len = hexVal.length(); 
           
            // Initializing base value to 1, i.e 16^0 
            int base = 1; 
           
            int dec_val = 0; 
           
            // Extracting characters as digits from last character 
            for (int i=len-1; i>=0; i--) 
            {    
                // if character lies in '0'-'9', converting  
                // it to integral 0-9 by subtracting 48 from 
                 if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') 
                { 
                    dec_val += (hexVal.charAt(i) - 48)*base; 
                       
                    // incrementing base by power 
                    base = base * 16; 
                } 
       
                // if character lies in 'A'-'F' , converting  
                // it to integral 10 - 15 by subtracting 55  
                // from ASCII value 
                else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') 
                { 
                    dec_val += (hexVal.charAt(i) - 55)*base; 
               
                    // incrementing base by power 
                    base = base*16; 
                } 
            } 
            return dec_val; 
        } 
          
 
        // function to convert decimal to hexadecimal 
    static void decToHexa(int n) 
       {    
            // char array to store hexadecimal number 
            char[] hexaDeciNum = new char[100]; 
           
            // counter for hexadecimal number array 
            int i = 0; 
            while(n!=0) 
            {    
                // temporary variable to store remainder 
                int temp  = 0; 
               
                // storing remainder in temp variable. 
                temp = n % 16; 
               
                // check if temp < 10 
                if(temp < 10) 
                { 
                    hexaDeciNum[i] = (char)(temp + 48); 
                    i++; 
                } 
                else
                { 
                    hexaDeciNum[i] = (char)(temp + 55); 
                    i++; 
                } 
               
                n = n/16; 
            } 
           
            // printing hexadecimal number array in reverse order 
            for(int j=i-1; j>=0; j--) 
                System.out.print(hexaDeciNum[j]); 
        } 
          
        
   public static void main (String[] args)  
        { 
            int n = 10; 
            decToHexa(n);
            System.out.println();
            String hexNum = "1A";     
            System.out.println(hexadecimalToDecimal(hexNum)); 
        } 
    } 
      
