import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Screen s1 = new Screen();
		List<Double> sides = new ArrayList<Double>();
		sides.add(5d);
		s1.addShape("square", 5d, 7d, sides);
		System.out.println(s1.getListOfShape().get(0).getShapeType());
		System.out.println(s1.getListOfShape().get(0).getTimeStamp());
		System.out.println(s1.getListOfShape().get(0).getArea());
		System.out.println(s1.getListOfShape().get(0).getOrigin());
		System.out.println("----------------");
		sides.add(4d);

		s1.addShape("rectangle", 2d, 7d, sides);
		System.out.println(s1.getListOfShape().get(1).getShapeType());
		System.out.println(s1.getListOfShape().get(1).getTimeStamp());
		System.out.println(s1.getListOfShape().get(1).getArea());
		System.out.println(s1.getListOfShape().get(1).getOrigin());
		System.out.println("----------------");

		sides.add(3d);
		s1.addShape("triangle", 8d, 3d, sides);
		System.out.println(s1.getListOfShape().get(2).getShapeType());
		System.out.println(s1.getListOfShape().get(2).getTimeStamp());
		System.out.println(s1.getListOfShape().get(2).getArea());
		System.out.println(s1.getListOfShape().get(2).getOrigin());
		System.out.println("----------------");

		ArrayList<Double> len = new ArrayList<Double>();
		len.add(4d);
		s1.addShape("circle", 4d, 4d, len);
		System.out.println(s1.getListOfShape().get(3).getShapeType());
		System.out.println(s1.getListOfShape().get(3).getTimeStamp());
		System.out.println(s1.getListOfShape().get(3).getArea());
		System.out.println(s1.getListOfShape().get(3).getOrigin());
		System.out.println("----------------");

		len.remove(0);

		List<Shape> obj = new ArrayList<Shape>();
		obj = s1.checkShapesEnclosingPoint(3d, 6d);
		for(int i=0;i<obj.size();i++){
			System.out.println(obj.get(i).getShapeType());
		}
		System.out.println("----------------");

		obj = s1.sortShapeBy("ärea");
		for(int i=0;i<obj.size();i++){
			System.out.println(obj.get(i).getShapeType());
		}
		System.out.println("----------------");

		System.out.println(s1.removeShape("circle"));		

	}

}
