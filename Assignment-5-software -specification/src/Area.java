
public class Area {
           final double Pi = 3.14;
           
           double areaOfTriangle(double width,double height)
           {
        	   return 0.5*width*height;
           }
           
           double areaOfRectangle(double width,double height)
           {
        	   return width*height;
           }
           
           double areaOfSquare(double side)
           {
        	   return side*side;
           }
           
           double areaOfCircle(double radius)
           {
        	   return Pi*radius*radius;
           }
           
           
           
           
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Area area = new Area();
		System.out.println("Area Of Circle Is: "+area.areaOfCircle(5.2));
		System.out.println("Area Of Rectangle Is: "+area.areaOfRectangle(10.0,5.2));
		System.out.println("Area Of Square Is: "+area.areaOfSquare(4.0));
		System.out.println("Area Of Triangle Is: "+area.areaOfTriangle(3.7,8.0));

	}

}
