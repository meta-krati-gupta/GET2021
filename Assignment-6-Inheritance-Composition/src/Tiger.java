
public class Tiger extends Mammals {
	
	public Tiger(int age,String name, String category, float weight, int speed,String sound){
		super(age, name, category, weight,speed,sound);
	}

	/**
	 * return sound
	 */
	public String getSound(){
		return super.soundOfAnimal;
	}
	/**
	 * return speed
	 */
	public int topSpeed(){
		return super.runningSpeed;
	}
}
