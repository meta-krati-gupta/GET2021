
import java.util.ArrayList;
/**
 * Zone class
 *
 */
public class Zones {
	final int limitOfCages;
	String typeOfZone;
	final int zoneId;
	static int counter = 0;
	ArrayList<Cage> listOfCages = new ArrayList<Cage>();
	boolean hasPark;
	boolean hasCanteen;
	
	/**
	 * Constructor
	 * @param capacityForCagesInZone
	 * @param zoneType
	 * @param park
	 * @param canteen
	 */
	public Zones(int capacityForCagesInZone,String zoneType,boolean park, boolean canteen) {
		
		limitOfCages = capacityForCagesInZone;
		 typeOfZone = zoneType;
		 zoneId = counter++;
		 hasPark = park;
		 hasCanteen = canteen;
	}

}