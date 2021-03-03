public class Lion extends Mammals {

	/**
	 * @param name
	 * @param sound
	 * @param age
	 * @param id
	 * @param runningSpeed
	 */
	public Lion(String name, String sound, int age, int id, int runningSpeed) {
		super(name, sound, age, id, runningSpeed);
	}

	/* 
	 * @see Animal#getName()
	 */
	@Override
	public String getName() {
		return null;
	}

	/* 
	 * @see Animal#getSound()
	 */
	@Override
	public String getSound() {
		return null;
	}

}