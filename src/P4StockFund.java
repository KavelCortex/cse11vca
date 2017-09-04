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

/**
 * class P4StockFund P4StockFund class is a container for holding values
 * and rates of return data for one account, also providing methods to
 * manipulate the data.
 **/
public class P4StockFund
{
  private final double  INIT_BUY = 5;      // Default buying amount
  private final double  VFINX    = 224.05; // Price for S&P 500 index fund

  final static double   MIN      = 0;      // Minimum for rate and balance
  final static double   MIN_ROI  = -1;     // Minimum -100% rate of return
  final static double   MAX_ROI  = 0.5;    // Maximum +50% rate of return

  private static double rateROI  = 0;      // Rate ROI for all accounts
  private double        value;             // Value of current account

  /**
   * No argument constructor of P4StockFund objects.
   **/
  public P4StockFund()
  {
    value = INIT_BUY * VFINX; // no arg ctor buys 5 shares by default.
  }

  /**
   * Overloaded constructor with one parameter indicates how much shares
   * user wants to buy.
   **/
  public P4StockFund(double shares)
  {
    value = shares * VFINX; // Buying shares based on parameter passed in
  }

  /**
   * Getter for private variable rateROI, to return the rate of return
   **/
  public double getRate()
  {
    return rateROI;
  }

  /**
   * this method validates user's input. Reject when input data is invalid.
   **/
  public static boolean setRateROI(double roi)
  {
    if (roi >= MIN_ROI && roi <= MAX_ROI) // check if roi is within range
    {
      rateROI = roi; // if valid, assign the data into variable,
      return true; // return true for feedback
    }
    return false; // otherwise, return false and skip the assignment.
  }

  /**
   * this method checks the validation of user's input data for buying
   * shares. Reject when input data is invalid.
   **/
  public boolean buyShares(double shares)
  {
    double transaction = 0; // Placeholder for user's pending balance

    // Try buying shares based on user's input
    transaction += shares * VFINX;
    transaction -= 10; // reduce $10 for transaction fee

    if (transaction <= 0) // if the balance becomes negative
      return false; // Call off the transaction.

    // Otherwise, make the transaction happen.
    value = transaction;
    return true; // feedback with positive.
  }

  /**
   * Each call of this method calculates the earnings for the next year.
   **/
  public void calcEarnings()
  {
    value *= (1 + rateROI); // Update user's balance.
  }

  /**
   * toString() returns a formatted String of user's balance
   */
  public String toString()
  {
    return String.format("$%.2f", value);
  }

}
