import java.util.*;

/**
 * This class contains operation to be performed on Shapes.
 */
public class Screen{
	private List<Shape> listOfShape = new ArrayList<Shape>();

	/**
	 * This function creates and adds new shape in a listOfShape list.
	 * @param type of shape.
	 * @param xCoordinate starting x-coordinate
	 * @param yCoordinate starting y-coordinate
	 * @param length sides length of shape
	 * @return true if shape is added else false.
	 * @throws AssertionError when parameters are invalid.
	 */
	public boolean addShape(String type, double xCoordinate, double yCoordinate,
			List<Double> length) throws AssertionError{
		if(type == null|| xCoordinate < 0|| yCoordinate < 0|| length.size() <= 0){
			throw new AssertionError("Provide valid parameters.");
		}
		StartingPoint start = new StartingPoint(xCoordinate,yCoordinate);
		Shape shapeObj = ShapeFactory.typeShapeFactory(type, start, length);
		getListOfShape().add(shapeObj);
		return true;
	}

	/**
	 * This function removes all shapes of same type.
	 * @param shapeType of object to be removed.
	 * @return true if shape found else false.
	 */
	public boolean removeAllShapesOfSameType(String shapeType){
		int i;
		for(i=0; i < getListOfShape().size();i++){
			if(getListOfShape().get(i).getShapeType().equalsIgnoreCase(shapeType)){
				getListOfShape().remove(i);
			}
		}
		if(getListOfShape().size() < i){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This  function sorts object list based on different user requirements.
	 * @param filter defines the type of sorting.
	 * @return list of objects after sorting.
	 */
	public List<Shape> sortShapeBy(String filter){

		if("area".equalsIgnoreCase(filter)){
			Collections.sort(getListOfShape() ,new AreaComparator());
		}
		else if("perimeter".equalsIgnoreCase(filter)){
			Collections.sort(getListOfShape() ,new PerimeterComparator());
		}
		else if("timestamp".equalsIgnoreCase(filter)){
			Collections.sort(getListOfShape() ,new TimeStampComparator());
		}
		else{
			Collections.sort(getListOfShape() ,new OriginDistComparator());
		}
		return getListOfShape();
	}

	/**
	 * This function checks is the provided corrdinates are enclosed by any shape or not.
	 * @param xCoord coordinate of point.
	 * @param yCoord coordinate of point.
	 * @return list of objects enclosing the point.
	 * @throws AssertionError if no object found enclosing the shape.
	 */
	public List<Shape> checkShapesEnclosingPoint(double xCoord,
			double yCoord) throws AssertionError {
		
		StartingPoint obj = new StartingPoint(xCoord,yCoord);
		List<Shape> enclosingShapeObjects = new ArrayList<Shape>();

		for(int i = 0; i<getListOfShape().size();i++){
			if(getListOfShape().get(i).isPointEnclosed(obj)){
				enclosingShapeObjects.add(getListOfShape().get(i));
			}
		}

		if(enclosingShapeObjects.size() == 0){
			throw new AssertionError("No object enclosing this point found.");
		}
		return enclosingShapeObjects;
	}

	/**
	 * This function removes shape from screen.
	 * @param shapeType object type to be removed.
	 * @return true if shape removed else false.
	 */
	public boolean removeShape(String shapeType){
		for(int i=0; i < getListOfShape().size();i++){
			if(getListOfShape().get(i).getShapeType().equalsIgnoreCase(shapeType)){
				getListOfShape().remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the listOfShape
	 */
	public List<Shape> getListOfShape() {
		return listOfShape;
	}

	/**
	 * @param listOfShape the listOfShape to set
	 */
	public void setListOfShape(List<Shape> listOfShape) {
		this.listOfShape = listOfShape;
	}
	
}
