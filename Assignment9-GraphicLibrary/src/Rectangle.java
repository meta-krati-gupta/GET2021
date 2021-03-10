import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * This class implements shape interface.
 * 
 */
public class Rectangle implements Shape {
	private String type = typeOfShape.RECTANGLE.toString();
	private double width,height;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	public Rectangle(StartingPoint obj, List<Double> length){
		width = length.get(0);
		height = length.get(1);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = width*height;
		perimeter = 2*(width + height);
		originDistance = Math.sqrt(Math.pow(coordinates.xCoordinate, 2) + Math.pow(coordinates.yCoordinate, 2));
		Date date= new Date();
		long time = date.getTime();
		tstamp = new Timestamp(time);
	}

	/**
	 * @return area of Rectangle
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * @return origin of Rectangle
	 */
	@Override
	public double getOrigin() {
		return originDistance;
	}

	/**
	 * @return perimeter of Rectangle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * @return Rectangle is bounded or not
	 */
	@Override
	public boolean isPointEnclosed(StartingPoint obj){
		if(obj.xCoordinate >= coordinates.xCoordinate && obj.xCoordinate <= coordinates.xCoordinate+width
				&& obj.yCoordinate >= coordinates.yCoordinate && obj.yCoordinate <= coordinates.yCoordinate+height)
			return true;
		return false;
	}

	/**
	 * @return Shape- rectangle
	 */
	@Override
	public String getShapeType() {
		return type;
	}

	/**
	 * @return timastamp of Rectangle
	 */
	@Override
	public Timestamp getTimeStamp() {
		return tstamp;
	}
}