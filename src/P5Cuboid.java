/**
 * Assignment 05
 * 
 * login: cs11vca
 * 
 * This is an application to calculate the area of different polygon using
 * classes and hierarchy.
 **/

/**
 * class P5Cuboid
 * 
 * This class is the subclass of P5Rectangle,representing the rectangle.
 **/
public class P5Cuboid extends P5Rectangle
{

  // default height is set to 1.1
  private final static double HEIGHT_DEFAULT = 1.1;

  private final static int    NUM_FACE_PAIR  = 2;

  private final static int    NUM_EDGE_PAIR  = 4;

  // height of the rectangle
  private double              height;

  /**
   * No-arg ctor, initialize height to 1.1 by default
   **/
  public P5Cuboid()
  {
    height = HEIGHT_DEFAULT;
  }

  /**
   * Overloaded ctor, initialize side, length and height to the parameter
   **/
  public P5Cuboid(double side, double length, double height)
  {
    super(side, length); // passing parameter to super for initialize.
    this.height = height;
  }

  /**
   * toString() return the name of the class and the size of the rectangle
   **/
  public String toString()
  {
    return (getName() + "\t" + getSide() + " x " + getLength() + " x "
        + height);
  }

  /**
   * setDim() sets dimensions of the cuboid
   **/
  public void setDim(double side, double length, double height)
  {
    super.setDim(side, length); // Let the superclass handles side and
                                // length
    this.height = height; // assign 3rd dimension
  }

  /**
   * perimeter() calculates the perimeter of the cuboid.
   **/
  public double perimeter()
  {
    return NUM_EDGE_PAIR * (getSide() + getLength() + height);
  }

  /**
   * area() calculates the surface area of the cuboid.
   **/
  public double area()
  {
    // there are 3 sets of areas, and each set has 2 faces.
    return NUM_FACE_PAIR * (getSide() * getLength()
        + getSide() * height
        + getLength() * height);
  }

  /**
   * volume() calculates the volume of the cuboid.
   **/
  public double volume()
  {
    return super.area() * height;
  }

}// end of class
