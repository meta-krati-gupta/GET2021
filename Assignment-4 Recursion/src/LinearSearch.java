

public class LinearSearch {
	
    
	static int arr[]={12,34,54,2,3};
	//recursive method to search key in arr
	static int recursion(int arr[],int start,int last,int key)
    {
    	if(last < start)
    		return -1;
    	if(arr[start] == key)
    		return start;
    	if(arr[last] == key)
    		return last;
    	return recursion(arr,start+1,last-1,key);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int key = 54;
         //method call to find key
         int index = recursion(arr,0,arr.length-1,key);
         if(index!=-1)
         {
            System.out.println("Element " + key + " is present at index " + index);
        	 
         }
         else
         {
        	 System.out.println("Element " + key + " is not present.");
         }
	}

}
