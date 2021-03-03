public abstract class Animal {
	
	final String name, sound;
	int age;
	final int id;
	static int counter = 1;
	/**
	 * @param name
	 * @param sound
	 * @param age
	 * @param id
	 */
	public Animal(String name, String sound, int age, int id) {
		this.name = name;
		this.sound = sound;
		this.age = age;
		this.id = id;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	/**
	 * @return the sound
	 */
	public String getSound(){
		return sound;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
}