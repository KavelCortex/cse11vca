
/**
 * Assignment 00 
 * login: cs11vca 
 * DUE: Saturday, August 12, 2017 @ 6:00am 
 * This program is an application to convert feet into inches.
 **/
import java.util.Scanner; // Scan input from keyboard

/**
 * class P0 This is the main class to perform the convert operation.
 **/
public class P0
{

  /**
   * main() accepts input, which is the feet value to be converted, then convert
   * feet into inches using factor. Finally, output the converted inches values.
   **/
  public static void main(String[] args)
  {
    final double INCH_PER_FT = 12.0; // Constant conversion factor
    int feet; // feet, values to be converted from user input
    double inches; // Placeholder for inches, the converted values

    Scanner scan = new Scanner(System.in); // Read input from keyboard

    System.out.println("This program convert feet to inches.");
    System.out.print("Enter a whole number in feet: ");

    feet = scan.nextInt(); // Collect user input as Integer
    inches = feet * INCH_PER_FT; // Convert into inches

    // Print the value with 2 places precision
    System.out.printf("%d feet is equal to %.2f inches\n", feet, inches);
  }

}
