import java.util.HashMap;

public class UniqueCharCounter {
	private static HashMap<String, Integer> cachedResult = new HashMap<>();

	/**
	 * Calculates the count of unique characters in str
	 * @param str
	 * @return total number of unique characters
	 */
	public static int count(String str) {
		if (cachedResult.containsKey(str))
			return cachedResult.get(str);
		else{
			String newString = "";
			newString += str.charAt(0);
			for (int i=1; i<str.length(); i++){
				//case sensitive
				if (!newString.contains(str.charAt(i)+"")){
					newString += str.charAt(i);
				}
				System.out.println(newString);
			}
			cachedResult.put(str, newString.length());
		}	
		return cachedResult.get(str);
	}
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Hi, I am Krati";
		
		System.out.println(count(s));
		
		String s2 = "Hi, I am Krati";
		
		System.out.println(count(s2));
	}
}