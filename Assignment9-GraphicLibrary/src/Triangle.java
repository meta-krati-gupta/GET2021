import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * This class implements shape interface.

 */
public class Triangle implements Shape {
	private String type = typeOfShape.TRIANGLE.toString();
	private double width,height;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	/**
	 * Constructor to
	 * Create a triangle
	 * 
	 * @param obj
	 * @param length
	 */
	public Triangle(StartingPoint obj, List<Double> length){
		width = length.get(0);
		height = length.get(1);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = (width*height)/2;
		perimeter = 2*(width + height);
		originDistance = Math.sqrt(Math.pow(coordinates.xCoordinate, 2) + Math.pow(coordinates.yCoordinate, 2));
		Date date= new Date();
		long time = date.getTime();
		tstamp = new Timestamp(time);
	}

	/**
	 * @return area of triangle
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * @return origin of triangle
	 */
	@Override
	public double getOrigin() {
		return originDistance;
	}

	/**
	 * @return perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * @return triangle is bounded or not
	 */
	@Override
	public boolean isPointEnclosed(StartingPoint obj) {
		if(obj.xCoordinate >= coordinates.xCoordinate && obj.xCoordinate <= coordinates.xCoordinate+width
				&& obj.yCoordinate >= coordinates.yCoordinate && obj.yCoordinate <= coordinates.yCoordinate+width)
			return true;
		return false;
	}

	/**
	 * @return shape- triangle
	 */
	@Override
	public String getShapeType() {
		return type;
	}

	/**
	 * @return timestamp of triangle
	 */
	@Override
	public Timestamp getTimeStamp() {
		return tstamp;
	}
}