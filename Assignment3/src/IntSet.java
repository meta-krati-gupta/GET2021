import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class IntSet {

	private final int[] intSet;
	/**
	 * class constructor
	 * @param arr
	 */

	public IntSet(int[] arr) {
		List<Integer> newArr = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(!newArr.contains(arr[i])){
				newArr.add(arr[i]);
			}
		}
		this.intSet = new int[newArr.size()];
		for (int i = 0; i < newArr.size(); i++) {
			intSet[i] = newArr.get(i);
		}
	}
	
	/**
	 * 
	 * @return the arrSet
	 */


	public int[] getIntSet() {
		return intSet;
	}
	
    /**
     * check whether x is a member of set
     * @param value
     * @return a boolean value
     */
	public boolean isMember(int value){
		for (int i = 0; i < intSet.length; i++) {
			if(intSet[i] == value){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return the size of the IntSet
	 */
	public int size(){
		return intSet.length;
	}
	
	/**
	 * check whether s is a subset of the set
	 * @param s
	 * @return
	 */
	public boolean isSubSet(IntSet s){
		for (int i : s.getIntSet()) {
			if(!this.isMember(i)){
				return false;
			}
		}
		return true;
	}

   /**
    * return union of this and s
    * @param s
    * @return union of this and s
    */
	public int[] union(IntSet s){
		List<Integer> newList = new ArrayList<Integer>();
		for (int i : this.intSet) {
			newList.add(i);
		}
		for (int i : s.getIntSet()) {
			if(!this.isMember(i)){
				newList.add(i);
			}
		}
		int[] union = newList.stream().mapToInt(i->i).toArray();
		return union;
	}
	
   /**
    * return complement set
    * @return the complement set
    */
	public int[] getComplement(){
		int n = this.intSet.length;
		int[] complementSet = new int[1000 - n];
		int index = 0;
		for (int i = 1; i < 50; i++) {
			if(!this.isMember(i)){
				complementSet[index++] = i;
			}
		}
		return complementSet;
	}


public static void main(String[] args){
	System.out.println("IntSet Test: ");
	IntSet intset1 = new IntSet(new int[]{1,2,3,4,6});
	IntSet intset2 = new IntSet(new int[]{3,5,6});
	System.out.println(Arrays.toString(intset1.getComplement()));
	System.out.println(Arrays.toString(intset1.union(intset2)));
	System.out.println(intset1.isSubSet(intset2));
	System.out.println(intset1.isMember(3));
	
	
}

}

