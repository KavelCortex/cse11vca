/**
 * Assignment 05
 * 
 * login: cs11vca
 * 
 * This is an application to calculate the area of different polygon using
 * classes and hierarchy.
 **/

/**
 * class P5RegHexPrism
 * 
 * This class is the subclass of P5RegHexagon,representing the Regular
 * Hexagon Prism.
 **/
public class P5RegHexPrism extends P5RegHexagon
{

  private double height; // height of the prism

  /**
   * No-arg ctor, initialize height to 1 by default
   **/
  public P5RegHexPrism()
  {
    height = 1;
  }

  /**
   * Overloaded ctor, initialize side and height to the parameter
   **/
  public P5RegHexPrism(double side, double height)
  {
    super(side);
    this.height = height;
  }

  /**
   * toString() return the name of the class and the size of the rectangle
   **/
  public String toString()
  {
    return (getName() + "\t" + getSide() + " x " + height);
  }

  /**
   * setDim() sets dimensions of the prism
   **/
  public void setDim(double s, double h)
  {
    setDim(s);// Let the superclass handles side and length
    height = h; // assign the height
  }

  /**
   * perimeter() calculates the perimeter of the prism.
   **/
  public double perimeter()
  {
    return super.perimeter();
  }

  /**
   * area() calculates the surface area of the prism.
   **/
  public double area()
  {
    // 2 of hexagon area plus 6 of rectangle area
    return 2 * super.area() + NUM_SIDE * getSide() * height;
  }

  /**
   * volume() calculates the volume of the prism.
   **/
  public double volume()
  {
    return super.area() * height;
  }

}// end of class
