public abstract class Mammals extends Animal {

	int runningSpeed;
	static final boolean HAVE_HAIRS = true;
	
	/**
	 * @param name
	 * @param sound
	 * @param age
	 * @param id
	 * @param runningSpeed
	 */
	public Mammals(String name, String sound, int age, int id, int runningSpeed) {
		super(name, sound, age, id);
		this.runningSpeed = runningSpeed;
	}

	/**
	 * @return the runningSpeed
	 */
	public int getRunningSpeed() {
		return runningSpeed;
	}

	/**
	 * @param runningSpeed the runningSpeed to set
	 */
	public void setRunningSpeed(int runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

}