/**
 * Assignment 05
 * 
 * login: cs11vca
 * 
 * This is an application to calculate the area of different polygon using
 * classes and hierarchy.
 **/

/**
 * class P5Polygon
 * 
 * This class is the abstract, fundamental class (superclass) of all
 * polygon classes in this assignment.
 **/
public abstract class P5Polygon
{
  public static final double SIDE_DEFAULT = 1;
  private double             side;            // sides of the polygon

  /**
   * No-arg ctor, initialize side to 1 by default
   **/
  public P5Polygon()
  {
    side = SIDE_DEFAULT;
  }

  /**
   * Overloaded ctor, initialize side to the parameter
   **/
  public P5Polygon(double side)
  {
    this.side = side;
  }

  /**
   * toString() only returns class name
   **/
  public String toString()
  {
    return getName() + "\t";
  }

  /**
   * getSide() returns the value of the private var side
   **/
  public double getSide()
  {
    return side;
  }

  /**
   * getName() gets name from class Class
   **/
  public String getName()
  {
    return (this.getClass().getName() + ": ");
  }

  /**
   * setDim() sets dimensions of the polygon
   **/
  public void setDim(double side)
  {
    this.side = side;
  }

  /**
   * these 2 setDim() below are abstract for subclasses to override.
   **/
  public abstract void setDim(double side, double length);

  public abstract void setDim(double side, double length, double height);

  /**
   * perimeter() calculates the perimeter of the polygon.
   **/
  public abstract double perimeter();

  /**
   * area() calculates the area of the polygon.
   **/
  public abstract double area();

  /**
   * volume() calculates the volume of the polygon.
   **/
  public abstract double volume();

}// end of class
