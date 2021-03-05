import java.util.LinkedHashMap;

/**
 * This is ZooManagement management Class.
 *
 */
public class ZooManagement {
	/*
	 * to add animal;
	 * to add cage automatically when animal arrives;
	 * remove animal when it dies;
	 */
	
	// tiger ----- String type,int age,String name, String category, float weight, int speed,String sound
	//zone ------int capacityForCagesInZone,String zoneType
	// cage ---- String typeOfAnimal, int capacity
	
	private LinkedHashMap<Integer,Zones> listOfZones = new LinkedHashMap<Integer,Zones>();
	
	/**
	 * This function adds zone in the ZooManagement.
	 * @param capacityOfCages sets capacity of cages in a zone.
	 * @param zoneType specifies category of animal to be kept in a zone.
	 * @param park if zone has a park.
	 * @param canteen if zone has a canteen.
	 * @return true if zone is added successfully else false.
	 */
	public boolean addZone(int capacityOfCages, String zoneType, boolean park, boolean canteen){
		Zones zoneObj = new Zones(capacityOfCages, zoneType, park, canteen);
		listOfZones.put(zoneObj.zoneId, zoneObj);
		return true;
	}
	
	public boolean addCage(String zoneType,String animalBreed, int capacity){
		Cage cageObj = new Cage(animalBreed, capacity);
		for(int i=0;i<listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == zoneType && listOfZones.get(i).limitOfCages > listOfZones.get(i).listOfCages.size())
			{
				listOfZones.get(i).listOfCages.add(cageObj);
				return true;
			}
		}
		return false;
	}
	
	//mammal
	public boolean addAnimal(String type,int age,String name, String category, float weight, int speed,String sound) throws AssertionError{
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, speed, sound);
		for(int i=0;i< listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == category){
				for(int j =0;j < listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
						throw new AssertionError("Animal with this name already present");
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	//bird
	public boolean addAnimal(String type,int age,String name, String category, float weight, boolean canFly,String sound) throws AssertionError{
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, canFly, sound);
		for(int i=0;i< listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == category){
				for(int j =0;j < listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
						throw new AssertionError("Animal with this name already present");
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	//reptile
	public boolean addAnimal(String type,int age,String name, String category, float weight, String swim,String sound) throws AssertionError{
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, swim, sound);
		for(int i=0;i< listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == category){
				for(int j =0;j < listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
						throw new AssertionError("Animal with this name already present");
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/*
	 * this method removes a dead animal from zoo
	 */
	public boolean removeAnimal(String category,String breed,String name){
		for(int i=0;i<listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone==category){
				for(int j =0;j<listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == breed && listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name)){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.remove(name);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * this method returns animal sound
	 */
	public String getAnimalSound(String category,String breed,String name) throws AssertionError{
		for(int i=0;i<listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone==category){
				for(int j =0;j<listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == breed){
						return listOfZones.get(i).listOfCages.get(j).listOfAnimal.get(name).getSound();
					}
				}
			}
		}
		throw new AssertionError("No animal of this breed");
	}
	
}