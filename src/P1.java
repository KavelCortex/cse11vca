/**
 * Assignment 01 
 * login: cs11vca
 * DUE: Saturday, August 12, 2017 @ 6:00am 
 * This program calculates an online book order's price for a student. 
 **/
import java.util.Scanner; // Scanner for input

/**
 * class P1 
 * This is the main class for the calculator program.
 * The user will be asked to input his or her student name, ISBN Code, 
 * vendor choice, and whether he or she wants to add more books, in order to
 * calculate the total price of books.
 **/
public class P1
{

  /**
   * main() accept user's name, listing the book available to order and
   * letting users to place their order using valid ISBN number and vendor
   * code. When order is done, display the total price of the order.
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

    
    // WHILE Loop for continuing placing order
    boolean wantsMore = true;
    while (wantsMore)
    {

      // Display the book price menu
      System.out.printf(BOOK_MENU_STR, PRICE_1A, PRICE_1B, PRICE_1C, PRICE_2A,
          PRICE_2B, PRICE_2C, PRICE_3A, PRICE_3B, PRICE_3C);

      /*----ISBN Validation----*/
      boolean isISBNValid = false;
      do // DO loop for ISBN Validation
      {
        System.out.print("Enter ISBN-10 (omit hyphens): ");
        isbn = scanner.nextLong(); // Collect user input as ISBN Code

        if (isbn > 0) // ISBN less than or equal to 0 is not allowed
        {
          // For each FOR loop, isbn compare isbn to the upper bound of
          // ISBN-10. if is out of bound, divide itself by 10 to drop the
          // last digit, and continue comparing. Stop the loop when
          // isbn is in the boundary.
          for (; isbn > MAX_ISBN_10; isbn /= 10)
            ;

          // Check if the requested book is available.
          // Cannot use long var as the parameter of switch,
          // thus, parse them into String var.
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

      /*----Vendor Validation----*/
      boolean isVendorValid = false;
      while (!isVendorValid) // WHILE loop for vendor validation
      {
        System.out.print("\nEnter Vendor letter (A-C): ");
        inputStr = scanner.next(); // Collect user input
        inputStr = inputStr.toUpperCase(); // Make input case-insensitive
        vendor = inputStr.charAt(0); //Take the first character as Vendor Code

        if (vendor >= 'A' && vendor <= 'C') // If Vendor Code is within range
          isVendorValid = true; // Set flag by TRUE to exit the loop
        else
          System.out.println("ERROR: range(A-C)!"); // continuing the loop
      }

      /*----Assembling Price----*/
      // Dealing C separately, for A and B have mostly the same price.
      if (vendor == 'C')
      {
        switch ("" + isbn)
        // Select the correct price of book based on ISBN Code
        {
          case "" + BOOK1:
            price += PRICE_1C;
            break;
          case "" + BOOK2:
            price += PRICE_2C;
            break;
          case "" + BOOK3:
            price += PRICE_3C;
            break;
          default:
            System.out.println("odd."); // Odd.
        }
      }
      
      // for vendor A and B
      else
      {
        switch ("" + isbn)
        {
          case "" + BOOK1: // Book 1&2 has the same price at different vendor.
            price += PRICE_1A;
            break;
          case "" + BOOK2: // Book 2
            price += PRICE_2A;
            break;
          case "" + BOOK3: // Book 3 is different. handle it.
            price += (vendor == 'A' ? PRICE_3A : PRICE_3B);
            break;
          default:
            System.out.println("Oddly odd."); // Oddly odd.
        } // end of switch ("" + isbn)
      } // end of else

      System.out.printf("%s, your total price for ISBN#:%d is %.2f\n", name,
          isbn, price); // Print totals

      // Ask user whether to continue the loop
      System.out.print("Want to order more books (y/n)? ");
      inputStr = scanner.next();
      inputStr = inputStr.toUpperCase();
      if (inputStr.charAt(0) == 'N')
        wantsMore = false; // Set flag to false to jump out of the WHILE loop.

    } // end of wantsMore

  } // end of main()
}
