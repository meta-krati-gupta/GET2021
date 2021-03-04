public class BinarySearch {
	//return index of key if it is present in arr else -1.
	public static  int binarySearch(int arr[],int first,int last,int key)
	{
		 //restrict boundary of right and left index
		if(last>=first)
		{
			int mid = (first+last)/2;
			//if element present at mid itself.
			
			if(arr[mid]==key)
			{
				return mid;
			}	
		//if element is smaller than mid ,so it can only present in left subarray.
			if(arr[mid]>key)
			{
				return binarySearch(arr,first,mid-1,key);
			}
			//else the element can only be present in right subarray
			
			return binarySearch(arr,mid+1,last,key);
			
		}
		//when element is not present in array.
	     return -1;
	}
	
	public static void main(String[] args) 
	{

		int arr[] = {10,12,14,15,16,20};
		int key = 12;
        int last = arr.length-1;
        int result = binarySearch(arr,0,last,key);
        if(result == -1)
        	System.out.println("Element not present in array.");
        else
        	System.out.println("Element found at index " + result);
	}
}
     