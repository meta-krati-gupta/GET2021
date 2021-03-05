public class Main {


	public static void main(String[] args){
		ZooManagement zoo = new ZooManagement();
		boolean check = false;
		check = zoo.addZone(2, "mammal",true,false);
		System.out.println(check);
		System.out.println("-------1--------");
		
		check = zoo.addZone(1, "reptile",false,true);
		System.out.println(check);
		System.out.println("--------2-------");
		
		check = zoo.addZone(1, "bird",true ,true);
		System.out.println(check);
		System.out.println("---------3------");
		
		check = zoo.addCage("mammal", "tiger", 2);
		System.out.println(check);
		System.out.println("----------4-----");
		
		check = zoo.addCage("bird","eagle", 1);
		System.out.println(check);
		System.out.println("-----------5----");
		
		check = zoo.addCage("reptile","crocodile", 1);
		System.out.println(check);
		System.out.println("----------6-----");
		
		check = zoo.addAnimal("tiger", 10, "ramu", "mammal", 50.00f, 65, "roar");
		System.out.println(check);
		System.out.println("-----------7----");
		
		check = zoo.removeAnimal("mammal", "tiger", "ramu");
		System.out.println(check);
		System.out.println("----------8-----");
		
		check = zoo.removeAnimal("reptile", "crocodile", "shyamu");
		System.out.println(check);
		System.out.println("---------9------");
		
		check = zoo.addAnimal("eagle", 5, "chiya", "bird", 10.00f, true, "beep");
		System.out.println(check);
		System.out.println("----------10-----");
		
		check = zoo.addAnimal("tiger", 10, "ramu", "mammal", 50.00f, 65, "roar");
		System.out.println(check);
		System.out.println("----------12-----");
		
		System.out.println(zoo.getAnimalSound("mammal","tiger","ramu"));
		System.out.println("----------13-----");
	} 
}
