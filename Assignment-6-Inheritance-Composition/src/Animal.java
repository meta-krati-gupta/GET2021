abstract public class Animal {
	int ageOfAnimal;
	static int counter =0;
	final int animalId;
	String animalName;
	String categoryOfAnimal;
	float weightOfAnimal;
	String soundOfAnimal;

	/**
	 * create new Animal
	 * @param age
	 * @param name
	 * @param category
	 * @param weight
	 * @param sound
	 */
	public Animal(int age,String name, String category, float weight,String sound) {
		this.ageOfAnimal = age;
		this.animalName = name;
		this.categoryOfAnimal = category;
		this.weightOfAnimal = weight;
		animalId = counter++;
		soundOfAnimal = sound;
	}

	/*
	 * return sound
	 */
	abstract public String getSound();
}
