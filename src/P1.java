
/**
 * Assignment 01 
 * login: cs11vca
 **/
import java.util.Scanner; // Scanner for input

/**
 * class P1 This program calculates an online book order for a student. The user
 * will be asked to input his or her student name, ISBN Code, vendor choice, and
 * whether he or she wants to add more books.
 **/
public class P1
{

  /**
   * @param args
   **/
  public static void main(String[] args)
  {
    final long MAX_ISBN_10 = 999999999; // Upper bound of ISBN-10
    final long BOOK1 = 134611037; // #1 Liang ISBN
    final long BOOK2 = 134791401; // #2 Deitel ISBN
    final long BOOK3 = 596002619; // #3 Unix ISBN

    final double PRICE_1A = 143.74; // #1 Liang AMAZON price
    final double PRICE_1B = 143.74; // #1 Liang BarnesNoble price
    final double PRICE_1C = 158.00; // #1 Liang UCSD price

    final double PRICE_2A = 134.90; // #2 Deitel AMAZON price
    final double PRICE_2B = 134.90; // #2 Deitel BarnesNoble price
    final double PRICE_2C = 149.00; // #2 Deitel UCSD price

    final double PRICE_3A = 16.99; // #3 Unix AMAZON price
    final double PRICE_3B = 24.75; // #3 Unix BarnesNoble price
    final double PRICE_3C = 29.99; // #3 Unix UCSD price

    // Display this menu after user entered his or her name
    final String BOOK_MENU_STR = "          CSE 11 TEXT BOOK ONLINE ORDER\n"
        + "=================================================\n"
        + " 1) Intro. to Java Programming Brief: Liang\n"
        + " 2) Java How to Program Late Objects: Deital\n"
        + " 3) Learning the Unix O/S: Peek, Todino, Strang\n"
        + "=================================================\n"
        + "      A)AMAZON    B)BarnesNoble    C)UCSD\n"
        + "   -------------------------------------------\n"
        + "   1)   $%6.2f      $%6.2f       $%6.2f\n"
        + "   2)   $%6.2f      $%6.2f       $%6.2f\n"
        + "   3)   $%6.2f      $%6.2f       $%6.2f\n"
        + "   -------------------------------------------\n";

    char loop = 'n'; // Decision whether to add more books
    char vendor = 0; // Decision in which vendor do the user choose
    long isbn = 0; // ISBN Code for the specific book to purchase
    double price = 0; // The total price for the book

    Scanner scanner = new Scanner(System.in); // Read input from keyboard
    String name = null; // Placeholder for student name
    String inputStr = null; // Placeholder for user input

    System.out.print("Enter students' name: ");
    name = scanner.next(); // Collect user input as student's name

    // Display the book price menu
    System.out.printf(BOOK_MENU_STR, PRICE_1A, PRICE_1B, PRICE_1C, PRICE_2A,
        PRICE_2B, PRICE_2C, PRICE_3A, PRICE_3B, PRICE_3C);

    // Collect and check ISBN input from user
    boolean isISBNValid = false;
    do // DO loop for ISBN Validation
    {
      System.out.print("Enter ISBN-10 (omit hyphens): ");
      isbn = scanner.nextLong(); // Collect user input as ISBN Code
                                 // (might be invalid)

      if (isbn > 0) // ISBN less or equal than 0 is not allowed
      {
        // For each FOR loop, isbn divide itself by 10 to drop the last digit,
        // then compare isbn to the upper bound of ISBN-10. Stop the loop when
        // isbn is in the boundary.
        for (; (isbn /= 10) > MAX_ISBN_10;)
          ;

        // Check if the requested book is available.
        // Cannot use long var as the parameter of switch,
        // therefore, parse them into String var.
        switch ("" + isbn)
        {
          case "" + BOOK1:
          case "" + BOOK2:
          case "" + BOOK3:
            isISBNValid = true;
            break;
          default:
            isISBNValid = false;
        }

        if (isISBNValid)
          break; // Break the loop if the corresponding book is available
      }
      // else, print an error message and continue the loop
      System.out.println("ERROR: None of these books!\n");

    } while (!isISBNValid);

    boolean isVendorValid = false;
    while (!isVendorValid) // WHILE loop for vendor validation
    {
      System.out.print("\nEnter Vendor letter (A-C): ");
      inputStr = scanner.next(); // Collect user input
      inputStr = inputStr.toUpperCase(); // Make input case-insensitive
      vendor = inputStr.charAt(0); // Take the first character as Vendor Code
      if (vendor >= 'A' && vendor <= 'C') // If the Vendor Code is within range
        isVendorValid = true; // Set flag by TRUE to exit the loop
      else
        System.out.println("ERROR: range(A-C)!"); // continuing the loop
    }

    // Dealing C separately, for A and B have mostly the same price.
    if (vendor == 'C')
    {
      switch ("" + isbn) // Select the correct price of book based on ISBN Code
      {
        case "" + BOOK1:
          price += PRICE_1C;
          isVendorValid = true;
          break;
        case "" + BOOK2:
          price += PRICE_2C;
          isVendorValid = true;
          break;
        case "" + BOOK3:
          price += PRICE_3C;
          isVendorValid = true;
          break;
        default:
          isVendorValid = false;
          System.out.println("odd.");
      }
    } else // for vendor A and B
    {
      switch ("" + isbn) // book 1 and 2 has the same price on different vendor
      {
        case "" + BOOK1:
          price += PRICE_1A;
          isVendorValid = true;
          break;
        case "" + BOOK2:
          price += PRICE_2A;
          isVendorValid = true;
          break;
        default:
          break;
      }
      if(isbn==BOOK3)
      {
        
      }

    }
  }
}
