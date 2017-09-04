
/**
 * Assignment 04 
 * login: cs11vca 
 * DUE: Wednesday, August 23, 2017 @ 6am
 * 
 * This application program is to calculate user's yearly earning of the
 * stock by gathering how many shares user wants to buy and the rates of
 * return of that stock.
 * 
 **/
import java.util.Scanner;

/**
 * class P4
 * 
 * Class P4 is the driver for gathering user input and instantiating
 * P4StockFund instances for calculating.
 **/
public class P4
{

  /**
   * main() is the main entrance for the program. This method instantiates
   * two P4StockFund objects for comparing the interest, with a infinite
   * loop for user to continuing input more stocks to compare, 'N' to exit.
   **/
  public static void main(String[] args)
  {
    final int YEAR1 = 1; // 1st year to open account
    final int YEARLAST = 10; // last year to open account
    final double START_BUY = 10; // Start to buy 10 shares
    final double YTD_ROI = 0.1393; // Year to Date Rate of Return Invest
    boolean isFirstRun = true; // No input on first return
    boolean errRate = false; // Valid rate of return
    int year; // Counter for displaying yearly earning in different years
    double rate; // Placeholder for user's input of ROI
    double fundShares; // Placeholder for user's input of fund shares

    Scanner scan = new Scanner(System.in); // Read input from keyboard
    String inputStr = new String(); // User's input to decide looping
    P4StockFund investor1 = new P4StockFund(START_BUY); // Double ctor
    P4StockFund investor2 = new P4StockFund(); // Noarg ctor, default by 5
    P4StockFund.setRateROI(YTD_ROI); // Setting current ROI
    do
    {
      if (!isFirstRun) // Testing ctor, no input on the first run
      {
        do
        {
          // Collect user's input for how many shares to buy
          System.out.print("Enter buy new fund shares:");
          fundShares = scan.nextDouble();

          // A valid share input must be larger than 0.
          if (fundShares > P4StockFund.MIN) // If valid
          {
            // Investor1 is for comparison, which will only buy 10 shares.
            investor1.buyShares(START_BUY);
            // Investor2 is for user funding shares.
            investor2.buyShares(fundShares);
            break; // Jump out of the validation loop
          }
          // If is not valid, print the error message and continue the loop
          System.out.println("Error! Enter Positive non-zero Shares.");
        } while (true); // Infinite loop for continuing validate
        do
        {
          // Collect user's input for the rate of return of the stock
          System.out.print("Enter new % rate of return (.01): ");
          rate = scan.nextDouble();
          // Check the validation of user's input and assign to errRate
          if (errRate = !investor2.setRateROI(rate)) // if is not valid
          {
            // Print error message and continue looping
            System.out.print("Error! Enter valid Range of ");
            System.out.println(P4StockFund.MIN_ROI + " to "
                + P4StockFund.MAX_ROI);
          }
        } while (errRate); // Jump out of the loop only when is valid
      }
      isFirstRun = false;// unlock the code above after first running

      // Display the chart
      System.out.printf("\nYearly earnings for 10 years at %.3f rate\n",
          investor1.getRate());
      System.out.printf("   %-7s%11s%16s\n", "YEAR", "INVESTOR 1",
          "INVESTOR 2");
      System.out.printf("   %-7s%11s%16s\n", "=====", "========", "=========");

      // Display the first year's fund
      System.out.printf("   %-7s%11s%16s\n", "Base",
          investor1.toString(), investor2.toString());

      // FOR loop to display next 10 years' fund
      for (year = YEAR1; year <= YEARLAST; year++)
      {
        // calculating earnings for next year
        investor1.calcEarnings();
        investor2.calcEarnings();

        // Display this year's earning
        System.out.printf("   %-7d%11s%16s\n",
            year, investor1.toString(), investor2.toString());
      }
      System.out.printf("   %-7s%11s%12s\n", "=====", "========", "=========");

      // Collect instruction if user wants to calculate a new round of
      // investment.
      System.out.print("Want to calculate more investments (y/n)? ");
      inputStr = scan.next();
      inputStr = inputStr.toUpperCase();

      // BREAK the loop if user typed 'n'
      if (inputStr.charAt(0) == 'N')
        break;
    } while (true); // infinite loop for continuing service
    scan.close(); // Close the scanner
    System.exit(0); // Exit to terminal
  } // End of main()
} // End of class
