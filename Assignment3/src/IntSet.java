import java.util.ArrayList;
import java.util.List;

public final class IntSet {

	private final int[] intSet;

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


	public int[] getIntSet() {
		return intSet;
	}
	

	public boolean isMember(int value){
		for (int i = 0; i < intSet.length; i++) {
			if(intSet[i] == value){
				return true;
			}
		}
		return false;
	}
	
	
	public int size(){
		return intSet.length;
	}
	
	public boolean isSubSet(IntSet s){
		for (int i : s.getIntSet()) {
			if(!this.isMember(i)){
				return false;
			}
		}
		return true;
	}


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
	

	public int[] getComplement(){
		int n = this.intSet.length;
		int[] complementSet = new int[1000 - n];
		int index = 0;
		for (int i = 1; i < 1000; i++) {
			if(!this.isMember(i)){
				complementSet[index++] = i;
			}
		}
		return complementSet;
	}
}