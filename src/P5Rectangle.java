/**
 * Assignment 05
 * 
 * login: cs11vca
 * 
 * This is an application to calculate the area of different polygon using
 * classes and hierarchy.
 **/

/**
 * class P5Rectangle
 * 
 * This is the subclass of P5Polygon, representing the rectangle.
 **/
public class P5Rectangle extends P5Polygon
{
  // Refer to the hand-out, the default value of length is 1.1
  private final static double LENGTH_DEFAULT = 1.1;

  // length of the rectangle
  private double              length;

  /**
   * No-arg ctor, initialize length to 1.1 by default
   **/
  public P5Rectangle()
  {
    length = LENGTH_DEFAULT; // default length of the rectangle
  }

  /**
   * Overloaded ctor, initialize side and length to the parameter
   **/
  public P5Rectangle(double side, double length)
  {
    super(side); // Initialize the side by parameter
    this.length = length; // Initialize the length by parameter
  }

  /**
   * toString() return the name of the class and the size of the rectangle
   **/
  public String toString()
  {
    return (getName() + "\t" + getSide() + " x " + length);
  }

  /**
   * getLength() returns the value of the private var length
   **/
  public double getLength()
  {
    return length;
  }

  /**
   * setDim() sets dimensions of the rectangle
   **/
  public void setDim(double side, double length)
  {
    super.setDim(side); // Let the superclass handles side
    this.length = length; // 2nd dimension should be assigned to length
  }

  /**
   * Since a rectangle doesn't have the 3rd dimension, we just ignore the
   * 3-dimension parameter height, and let the 2-dimension setDim() to
   * handle it.
   **/
  public void setDim(double side, double length, double height)
  {
    setDim(side, length); // ignore the 3rd dimension
  }

  /**
   * perimeter() calculates the perimeter of the rectangle.
   **/
  public double perimeter()
  {
    return (super.getSide() + length) * 2;
  }

  /**
   * area() calculates the area of the rectangle.
   **/
  public double area()
  {
    return super.getSide() * length;
  }

  /**
   * volume() calculates the volume of the rectangle. Since an rectangle
   * doesn't have the 3rd dimension, volume will be 0.
   **/
  public double volume()
  {
    return 0;
  }

}// end of class
