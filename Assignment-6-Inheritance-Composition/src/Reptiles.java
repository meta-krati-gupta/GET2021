public abstract class Reptiles extends Animal {

	final boolean canSwim;
	
	/**
	 * @param name
	 * @param sound
	 * @param age
	 * @param id
	 * @param canSwim
	 */
	public Reptiles(String name, String sound, int age, int id, boolean canSwim) {
		super(name, sound, age, id);
		this.canSwim = canSwim;
	}

	/**
	 * @return the canSwim
	 */
	public boolean isCanSwim() {
		return canSwim;
	}
	
}
