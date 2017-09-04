/**
 * Assignment 05
 * 
 * login: cs11vca
 * 
 * This is an application to calculate the area of different polygon using
 * classes and hierarchy.
 **/

/**
 * class P5RegHexagon
 * 
 * This class is the subclass of P5Polygon,representing the Regular
 * Hexagon.
 **/
public class P5RegHexagon extends P5Polygon
{
  // a hexagon has 6 side
  protected final static int    NUM_SIDE = 6;

  // Equation from hand-out to calculate regular hexagon.
  // Still need to manually multiply the squared length.
  protected final static double EQUATION = (3 * Math.sqrt(3)) / 2;

  /**
   * No-arg ctor, initialize height to 1 by default
   **/
  public P5RegHexagon()
  {
    super();
  }

  /**
   * Overloaded ctor, initialize side to the parameter
   **/
  public P5RegHexagon(double s)
  {
    super(s);
  }

  /**
   * toString() return the name of the class and the size of the RegHexagon
   **/
  public String toString()
  {
    return (getName() + "\t" + getSide() + "\t");
  }

  /**
   * setDim() sets dimensions of the hexagon
   **/
  public void setDim(double side, double length)
  {
    super.setDim(side); // ignore anything unsuitable
  }

  /**
   * Since a hexagon doesn't have the 3rd dimension, we just ignore length
   * and height.
   **/
  public void setDim(double side, double length, double height)
  {
    setDim(side); // ignore anything unsuitable
  }

  /**
   * perimeter() calculates the perimeter of the hexagon.
   **/
  public double perimeter()
  {
    return getSide() * NUM_SIDE;
  }

  /**
   * area() calculates the area of the hexagon.
   **/
  public double area()
  {
    return EQUATION * getSide() * getSide();
  }

  /**
   * volume() calculates the volume of the hexagon. Since a hexagon doesn't
   * have the 3rd dimension, volume will be 0.
   **/
  public double volume()
  {
    return 0;
  }

}// end of class
