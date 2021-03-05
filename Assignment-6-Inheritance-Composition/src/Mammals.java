abstract public class Mammals extends Animal {
	int runningSpeed;
	
	/**
	 * Constructor
	 * @param age
	 * @param name
	 * @param category
	 * @param weight
	 * @param speed
	 * @param sound
	 */
	public Mammals(int age,String name, String category, float weight,int speed,String sound) {
		super(age,name,category,weight,sound);
		runningSpeed = speed;
	}

	/**
	 * return speed
	 */
	abstract public int topSpeed();
}