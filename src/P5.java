import java.util.Scanner;

/**
 * Assignment 05
 * 
 * login: cs11vca
 * 
 * This is an application to calculate the area of different polygon using
 * classes and hierarchy.
 **/

/**
 * class P5
 * 
 * P5 is the driver of the application.
 **/
public class P5
{
  private static final int   POLYS = 4; // total number of the polygon
  private static P5Polygon[] a;         // arrays for polygons

  /**
   * main() handles the initialization of polygons. Also allow user's input
   * to customize the polygon. A loop is established for continuing running
   * the program.
   **/
  public static void main(String[] args)
  {
    char choice; // input form user to determine whether to continue loop
    double side; // input for hexagon and rectangle's side
    double length; // input for rectangle's length
    double height; // input for prism and cuboid's height
    Scanner scan = new Scanner(System.in); // read from keyboard
    String inputStr = null; // user's input

    a = new P5Polygon[POLYS]; // allocate heap for array
    a[0] = new P5RegHexagon(); // assign hexagon
    a[1] = new P5RegHexPrism(1.1, 2.2); // assign prism
    a[2] = new P5Rectangle(); // assign rectangle
    a[3] = new P5Cuboid(2.2, 3.3, 4.4); // assign cuboid
    prt(); // display polygon's spec

    do // DO loop for continuing running
    {
      // gather user's customization
      System.out.print("\nEnter Haxagon and Rectangle (side): ");
      side = scan.nextDouble();
      System.out.print("Enter Rectangle langth: ");
      length = scan.nextDouble();
      System.out.print("Enter HexPrism and Cuboid(height): ");
      height = scan.nextDouble();

      // Set polygons
      a[0].setDim(side);
      a[1].setDim(side, height);
      a[2].setDim(side, length);
      a[3].setDim(side, length, height);
      prt(); // Display new specs

      // ask user whether to continue
      System.out.print("\nWant to compute area (y/n)? ");
      inputStr = scan.next();
      inputStr = inputStr.toUpperCase();
      choice = inputStr.charAt(0);
    } while (choice != 'N'); // break if n or N
  }

  /**
   * Iterate the array and format the information of the polygons and
   * display.
   **/
  public static void prt()
  {
    int i;
    for (i = 0; i < POLYS; ++i)
      if (i % 2 == 0)
      {
        System.out.print(a[i] + "\thas an area: ");
        System.out.printf("%.2f", a[i].area());
        System.out.print("\tperimeter: ");
        System.out.printf("%.2f\n", a[i].perimeter());
      } else
      {
        System.out.print(a[i] + "\thas a surface area:");
        System.out.printf("%.2f", a[i].area());
        System.out.printf("\tvolume: %.2f\n", a[i].volume());
      }
  }

} // end of class
