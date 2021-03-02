import java.util.Scanner;


public class BinarySearch {
	//return index of key if it is present in arr else -1.
	 int binarySearch(int arr[],int start,int end,int key)
	{
		 //restrict boundary of right and left index
		if(start>=end)
		{
			int mid = (start+end)/2;
			//if element present at mid itself.
			
			if(arr[mid]==key)
			{
				return mid;
			}	
		//if element is smaller than mid ,so it can only present in left subarray.
			if(arr[mid]>key)
			{
				return binarySearch(arr,start,mid-1,key);
			}
			//else the element can only be present in right subarray
			
			return binarySearch(arr,mid+1,end,key);
			
		}
		//when element is not present in array.
	     return -1;
	}
	
	public static void main(String[] args) 
	{
		BinarySearch ob = new BinaySearch();
		int arr[] = {10,12,14,15,16,20};
		int n = arr.length;
		int key = 12;
        int result = ob.binarySearch(arr,0,n-1,key);
       
        if(result == -1)
        	System.out.println("Element not present in array.");
        else
        	System.out.println("Element found at index " + result);
	}
}
     