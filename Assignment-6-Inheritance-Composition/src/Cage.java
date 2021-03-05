import java.util.HashMap;

/**
 * Cage class
 *
 */
public class Cage {
	final String animalBreed;
	final int cageId;
	static int counter =0;
	HashMap<String,Animal> listOfAnimal = new HashMap<>();
	final int capacityOfCage;
	
	/**
	 * Constructor
	 * @param typeOfAnimal
	 * @param capacity
	 */
	public Cage(String typeOfAnimal, int capacity){
		animalBreed = typeOfAnimal;
		capacityOfCage = capacity;
		cageId = counter++;
	}
}