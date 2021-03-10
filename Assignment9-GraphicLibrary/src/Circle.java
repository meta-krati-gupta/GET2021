import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * This class implements shape interface.
 *
 */
public class Circle implements Shape {
	private String type = typeOfShape.CIRCLE.toString();
	private double radius;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	/**
	 * Constructor
	 * @param obj
	 * @param length
	 */
	public Circle(StartingPoint obj, List<Double> length){
		radius = length.get(0);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = Math.PI*Math.pow(radius,2);
		perimeter = 2*Math.PI*radius;
		originDistance = Math.sqrt(Math.pow(coordinates.xCoordinate, 2) + Math.pow(coordinates.yCoordinate, 2));
		Date date= new Date();
		long time = date.getTime();
		tstamp = new Timestamp(time);
	}

	/**
	 * @return area of circle
	 */
	@Override
	public double getArea() {
		return area;
	}


	/**
	 * @return origin of circle
	 */
	@Override
	public double getOrigin() {
		return originDistance;
	}


	/**
	 * @return perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}


	/**
	 * @return shape is bounded or not
	 */
	@Override
	public boolean isPointEnclosed(StartingPoint obj) {
		if( Math.sqrt(Math.pow(obj.xCoordinate - coordinates.xCoordinate, 2) + Math.pow(obj.xCoordinate - coordinates.yCoordinate, 2)) <= radius)
			return true;
		return false;
	}


	/**
	 * @return shape- circle
	 */
	@Override
	public String getShapeType() {
		return type;
	}

	/**
	 * @return timestamp of circle
	 */
	@Override
	public Timestamp getTimeStamp() {
		return tstamp;
	}
}
