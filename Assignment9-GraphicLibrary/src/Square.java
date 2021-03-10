import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

/**
 * This class implements shape interface.
 *
 */
public class Square implements Shape {
	private String type = typeOfShape.SQUARE.toString();
	private double width;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	/**
	 * Constructor to
	 * Create a square
	 * 
	 * @param obj
	 * @param length
	 */
	public Square(StartingPoint obj, List<Double> length){
		width = length.get(0);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = width*width;
		perimeter = 4*width;
		originDistance = Math.sqrt(Math.pow(coordinates.xCoordinate, 2) + Math.pow(coordinates.yCoordinate, 2));
		Date date= new Date();
		long time = date.getTime();
		tstamp = new Timestamp(time);
	}

	/**
	 * @return area of square
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * @return origin of square
	 */
	@Override
	public double getOrigin() {
		return originDistance;
	}

	/**
	 * @return perimeter of square
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * @return square is bounded or not
	 */
	@Override
	public boolean isPointEnclosed(StartingPoint obj){
		if(obj.xCoordinate >= coordinates.xCoordinate && obj.xCoordinate <= coordinates.xCoordinate+width
				&& obj.yCoordinate >= coordinates.yCoordinate && obj.yCoordinate <= coordinates.yCoordinate+width)
			return true;
		return false;
	}

	/**
	 * @return shape- square
	 */
	@Override
	public String getShapeType() {
		return type;
	}

	/**
	 * @return timestamp of square
	 */
	@Override
	public Timestamp getTimeStamp() {
		return tstamp;
	}
}
