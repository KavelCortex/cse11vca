/**
 * Assignment 02 
 * login: cs11vca 
 * DUE: Wednesday, August 16, 2017 @ 6:00am 
 * This program is to help calculate the price of coffee orders.
 **/
import java.util.Scanner;
/**
 * class P2 
 * This is the main class of the program, which contains method to
 * display menu, take orders, calculate price and handle free coffees.
 **/
public class P2
{

  // Prices for all 4 size of coffee
  private static final double $TALL     = 2.95;
  private static final double $GRANDE   = 3.65;
  private static final double $VENTI    = 4.15;
  private static final double $TRENTA   = 4.65;
  private static final double $XSHOT    = 0.80;

  // Menu String to display
  private static final String MENU_STR  = "************  JAVA JOY  ************"
      + "\n    SIZE                   PRICE\n"
      + "    =================      =====\n"
      + "    A)  Tall   (12 oz)     $.2f\n"
      + "    B)  Grande (16 oz)     $.2f\n"
      + "    C)  Venti  (20 oz)     $.2f\n"
      + "    D)  Trenta (31 oz)     $.2f\n"
      + "************************************\n";

  // Accumulator for total price of coffee
  private static int          totalJava = 0;

  // Scanner form user keyboard
  private static Scanner      scan      = new Scanner(System.in);

  /**
   * main() handles the main procedure for ordering coffees. This method
   * contains a loop for continue ordering coffees, a checker for Coffee type
   * and quantity from user input, and calls toward other methods for ordering
   * and displaying details.
   **/
  public static void main(String[] args)
  {

    String inputStr = null; // Placeholder for user input
    char type = 'Z'; // coffee types
    int quantity = 0; // coffee counts
    double totalPrice = 0; // total price of coffees
    char wantMoreJava = 'N'; // input from user to decide whether to continue

    do // DO loop for continue ordering
    {
      menu(); // Display a coffee menu

      boolean invalidDrink = false; // a flag to determine a bad input
      do // DO loop for user input a type of drink
      {
        // Collect user input for type
        System.out.print("Enter Type of drink (A B C or D): ");
        inputStr = scan.next();
        inputStr = inputStr.toUpperCase();
        type = inputStr.charAt(0);

        // Whether the input is within the range. Since True means invalid,
        // use ! to reverse.
        invalidDrink = !(type >= 'A' && type <= 'D');

        if (invalidDrink) // if invalid, print error message
          System.out.println("ERROR! Types Only: A B C or D");

      } while (invalidDrink); // Loop when input is invalid

      // WHILE loop for user input the quantity of coffee
      while (true) // Infinite loop, saving a boolean variable
      {
        // Collect user input for quantity
        System.out.print("Enter Quantity (1-11): ");
        quantity = scan.nextInt();
        if (quantity >= 1 && quantity <= 11) // whether input is within range
          break; // If qualified, break the loop

        // else means invalid, continue to next loop
        System.out.println("ERROR! Quantity Only: (1-11)!");
      }

      // calculate the price and add to accumulator
      if (quantity == 1)
        totalPrice += calcPrice(type); // use this method for 1 coffee
      else
        totalPrice += calcPrice(type, quantity); // use this for multiple coffee

      // ask user for ordering more coffee
      System.out.print("Want more Java (y/n)?: ");
      inputStr = scan.next();
      inputStr = inputStr.toUpperCase();
      wantMoreJava = inputStr.charAt(0);
    } while (wantMoreJava != 'N'); // Stop only if user said 'N' or 'n'

    payDrinks(wantMoreJava, totalPrice); // Print receipt

  }

  /**
   * menu() is for displaying menu of coffees, containing each size of coffees
   * available with their prices.
   **/
  public static void menu()
  {
    System.out.printf(MENU_STR, $TALL, $GRANDE, $VENTI, $TRENTA);
  }

  /**
   * calcPrice() method with one parameter is a shortcut to the more completed
   * version of calcPrice(), which deals multiple order in one time. This
   * shortcut is for one coffee ordering.
   **/
  public static double calcPrice(char typeJava)
  {
    // Detour to a completed version of calcPrice()
    return calcPrice(typeJava, 1);
  }

  /**
   * calcPrice() method with two parameter is the main method for calculating
   * orders for coffee. it can handle the price if the user wants an extra shot
   * for their coffees. if a free drink is available, it will skip the price
   * automatically.
   **/
  public static double calcPrice(char typeJava, int numJava)
  {
    String inputStr = null; // Placeholder for user input
    char wantXShot = 'N'; // whether user wants an extra shot
    double localTotal = 0; // local total price for each calcPrice() called

    // Collet user input for an extra shot
    System.out.printf(
        "\nWant an extra shot ($%.2f each) on your drink(s) (y/n): ", $XSHOT);
    inputStr = scan.next();
    inputStr = inputStr.toUpperCase();
    wantXShot = inputStr.charAt(0);

    // FOR each coffee user ordered in this method
    for (int currentJava = 1; currentJava <= numJava; currentJava++)
    {
      // If this one is the lucky 11th, we'll happily to skip the pay.
      if (freeDrink(typeJava, wantXShot) != 0)
        continue;

      // Determine the type of coffee, accumulate the price by different type.
      switch (typeJava)
      {
        case 'A':
          localTotal += $TALL;
          break;
        case 'B':
          localTotal += $GRANDE;
          break;
        case 'C':
          localTotal += $VENTI;
          break;
        case 'D':
          localTotal += $TRENTA;
          break;
        default:
          System.out.println("ODD."); // ODD.
      }

      // if user wants an extra shot, we'll add the price for the shot.
      // Otherwise, a zero is added.
      // Attention, this procedure is running FOR each coffee ordered,
      // thus, no coffee will be skipped (except for those lucky ones).
      localTotal += (wantXShot == 'Y' ? $XSHOT : 0);
    }

    // Finally, return the total for this order.
    return localTotal;
  }

  /**
   * freeDrink() can determine whether this coffee is qualified for a free
   * drink.
   **/
  public static double freeDrink(char typeJava, char extraShot)
  {
    double priceOFF = 0;

    // For each time called this method, a global variable totalJava will be
    // added by one, so it can tell if the coffee is qualified.
    totalJava++;

    // Qualified coffee can be divided by 11.
    if (totalJava % 11 == 0)
    {
      // Finds out the worth of the free coffee
      switch (typeJava)
      {
        case 'A':
          priceOFF = $TALL;
          break;
        case 'B':
          priceOFF = $GRANDE;
          break;
        case 'C':
          priceOFF = $VENTI;
          break;
        case 'D':
          priceOFF = $TRENTA;
          break;
        default:
          System.out.println("odd."); // odd.
      }

      // Accumulate the price of an extra shot if ordered.
      priceOFF += (extraShot == 'Y' ? $XSHOT : 0);

      // Show users the lucky message
      System.out.printf("ONE FREE DRINK wroth $%.2f\n", priceOFF);
    }

    // Return the price the user saved. if it returns 0, means there is no free
    // coffee.
    return priceOFF;
  }

  // Display a receipt for total price of the order.
  public static void payDrinks(char moreJava, double money)
  {
    if (moreJava != 'N') // Only show when there's no more coffee ordered.
      return;
    System.out.printf("\nTotal (tax included): $%.2f\n", money);
  }

}
