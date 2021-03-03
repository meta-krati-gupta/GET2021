public abstract class Birds extends Animal {

	final boolean canfly;
	
	/**
	 * @param name
	 * @param sound
	 * @param age
	 * @param id
	 * @param canfly
	 */
	public Birds(String name, String sound, int age, int id, boolean canfly) {
		super(name, sound, age, id);
		this.canfly = canfly;
	}

	/**
	 * @return the can fly or not
	 */
	public boolean isCanfly() {
		return canfly;
	}

}
