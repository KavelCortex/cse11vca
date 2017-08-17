
/**
 * Assignment 03
 * 
 * login: cs11vca
 * 
 * This program is to help sorting and analyzing students' score with their
 * names.
 **/
import java.util.Scanner; // Scanner

/**
 * class P3
 * 
 * This class is the main class of the program, contains several method
 * which can manage user input and help sorting and analyzing arrays of
 * students' name and their scores.
 **/
public class P3
{
  // Menu Strings
  private final static String MENU_STR =
      "   ===================================\n"
          + "    1  Ascending  Sort of Scores\n"
          + "    2  Descending Sort of Scores\n"
          + "    3  Ascending  Sort of Names\n"
          + "    4  Descending Sort of Names\n"
          + "    5  Above Average Scores with Names\n"
          + "    6  Below Average Scores with Names\n"
          + "   -1  EXIT\n"
          + "   ===================================\n";

  // Array of scores of students
  private static double[]     scores;

  // Array of names of students
  private static String[]     names;

  // Read input from keyboard
  private static Scanner      scan     = new Scanner(System.in);

  /**
   * main() is the main entrance of the program. In main(), user are asked
   * to input the type to handle the data by calling menu(). Once a valid
   * input received, program will call a specified sorting method based on
   * user's input. This program won't stop until a stopping command input
   * (-1) is received.
   **/
  public static void main(String[] args)
  {
    int numStudents; // Number Of Students
    int typeOfSort; // Which type of sort

    do // DO loop for continuing run the program.
    {
      typeOfSort = menu(); // Calling menu() to receive valid command.
      if (typeOfSort == -1) // Exit on -1
        break;

      // Collect user input as the number of students.
      System.out.print("   Enter the number of students: ");
      numStudents = scan.nextInt();

      // Initiate arrays based on the number of students.
      names = new String[numStudents];
      scores = new double[numStudents];

      readInput(); // Calling readInput() to gather students' info.

      // Determine which sorting method based on user's input
      switch (typeOfSort)
      {
        case 1: // Ascend sort scores.
          selectionAscendScore();
          prt();
          break;
        case 2: // Descend sort scores.
          bubbleDescendScore();
          prt();
          break;
        case 3: // Ascend sort names.
          bubbleAscendString();
          prt();
          break;
        case 4: // Descend sort names.
          bubbleDescendString();
          prt();
          break;
        case 5: // Display students whose score is above average.
          aboveAverage();
          break;
        case 6: // Display students whose score is below average.
          belowAverage();
          break;
        default:
          System.out.println("odd."); // odd.
      }
    } while (true); // Infinite loop, exit on -1
    scan.close(); // Close the scanner
    System.exit(0); // Exit to terminal
  }

  /**
   * menu() displays menu and collects user input, validates the input and
   * returns it for further usage.
   **/
  public static int menu()
  {
    while (true) // Infinite loop until input is valid.
    {
      int userInput = 0; // Placeholder for user input
      System.out.print(MENU_STR); // Display the menu
      System.out.print("   Choose type of sort (1 2 3 4 5 6): ");
      userInput = scan.nextInt(); // Collect user input
      if (userInput >= -1 && userInput <= 6 && userInput != 0)
        return userInput; // If the input is valid, return.

      // print error message and loop.
      System.out.println("ERROR! Types only (1 2 3 4 5 6), -1 to exit");
    }
  }

  /**
   * readInput() can collect user's input about name and scores. Times of
   * input loop varies with the length of arrays.
   **/
  public static void readInput()
  {
    // Loop through all columns of array
    for (int i = 0; i < names.length; i++)
    {
      // Collect user's input as name of the student
      System.out.printf("Enter student name  #%d: ", i + 1);
      names[i] = scan.next();

      // Collect user's input as score of the student
      System.out.printf("Enter student score #%d: ", i + 1);
      scores[i] = scan.nextInt();
    }
  }

  /**
   * Ascend score using SelectionSort
   **/
  public static void selectionAscendScore()
  {
    double min; // Place holder for the 'minimum' for each iteration
    int minIndex; // The index of the 'minimum'

    // Sorting begins from the first element of the array to the end. Each
    // iteration picks up one element as a 'scout'.
    for (int i = 0; i < scores.length; i++)
    {

      min = scores[i]; // Let the 'minimum' be the 'scout'
      minIndex = i; // the index of the 'minimum'

      // Searching the rest of the array
      for (int j = i + 1; j < scores.length; j++)
      {
        // If 'scout' is larger than one of the searching elements in the
        // array, or with the same value but 'scout' is having a *larger*
        // name,
        if ((min > scores[j]) || (min == scores[j] &&
            names[i].compareTo(names[j]) > 0))
        {

          min = scores[j]; // Let that element be the 'minimum'.
          minIndex = j; // Update the index as well.
        }
      }
      if (minIndex != i) // If the 'minimum' is no longer the 'scout',
        swap(i, minIndex); // swap 'minimum' and 'scout'.
    }
  }

  /**
   * Descend score using BubbleSort
   **/
  public static void bubbleDescendScore()
  {

    // Sorting ranges from the first element to the end. Each iteration
    // leaves out the first element from the rest of the array because
    // that one is well sorted.
    for (int i = 0; i < scores.length; i++)

      // Sorting progress begins from the end of the array to the sorting
      // boundary.
      for (int j = scores.length - 1; j > i; j--)
      {
        // If the next element is smaller than this one, or with the same
        // value but the name of it is *smaller* than this one,
        if ((scores[j - 1] < scores[j]) || (scores[j - 1] == scores[j]
            && names[j - 1].compareTo(names[j]) < 0))
          swap(j - 1, j); // Swap two elements, since it is descending.
      }
  }

  /**
   * Ascend name using BubbleSort
   **/
  public static void bubbleAscendString()
  {

    for (int i = 0; i < names.length; i++)
      for (int j = names.length - 1; j > i; j--)
      {
        // Compare next one's name with this one's and gives the result.
        int comparison = names[j - 1].compareTo(names[j]);

        // If next one's name is *larger* than this one's, or with the same
        // weight but next one's score is greater than this one,
        if ((comparison > 0) || (comparison == 0 && scores[j - 1] > scores[j]))
          swap(j - 1, j); // Swap two elements, since it is ascending.
      }

  }

  /**
   * Descend name using BubbleSort
   **/
  public static void bubbleDescendString()
  {
    for (int i = 0; i < names.length; i++)
      for (int j = names.length - 1; j > i; j--)
      {
        // Compare next one's name with this one's and gives the result.
        int comparison = names[j - 1].compareTo(names[j]);

        // If next one's name is *smaller* than this one's, or with the
        // same
        // weight but next one's score is lesser than this one,
        if ((comparison < 0) || (comparison == 0 && scores[i] < scores[j]))
          swap(j - 1, j); // Swap two elements, since it is descending.
      }
  }

  /**
   * aboveAverage() analyze and show which student is above average with
   * their names and scores.
   **/
  public static void aboveAverage()
  {
    selectionAscendScore(); // Perform ascending sort first
    double avg = 0; // Average score:
    for (int i = 0; i < scores.length; i++) // FOR each elements in array,
      avg += scores[i]; // accumulate all scores,
    avg = avg / scores.length; // and divide them with the number of
                               // students.

    // Display average.
    System.out.printf("     AVERAGE score: %.2f\n", avg);

    System.out.println("     ABOVE AVERAGE STUDENTS");

    int idx; // Index for arrays

    // FOR students below the average,
    for (idx = 0; scores[idx] < avg; idx++)
      ; // Skip them by doing nothing

    // After skipping, index should be at the element which is above the
    // average.
    for (int i = idx; i < scores.length; i++) // From here to the end
      System.out.printf("     %s  %.1f\n", names[i], scores[i]); // print
  }

  /**
   * belowAverage() analyze and show which student is below average with
   * their names and scores.
   **/
  public static void belowAverage()
  {
    bubbleDescendScore(); // Perform descending sort first
    double avg = 0; // Average score, same as above
    for (int i = 0; i < scores.length; i++)
      avg += scores[i];
    avg = avg / scores.length;

    // Display average.
    System.out.printf("     AVERAGE score: %.2f\n", avg);

    System.out.println("     BELOW AVERAGE STUDENTS");

    int idx;
    // FOR students above the average,
    for (idx = 0; scores[idx] > avg; idx++)
      ; // Skip them by doing nothing

    // After skipping, index should be at the element which is below the
    // average.
    for (int i = idx; i < scores.length; i++)
      System.out.printf("     %s  %.1f\n", names[i], scores[i]); // print
  }

  /**
   * swap() can perform a swap by receiving two indices of the element
   * which are needed to be swapped.
   */
  public static void swap(int idx_i, int idx_j)
  {

    // Swapping names
    String tmpNames = names[idx_i];
    names[idx_i] = names[idx_j];
    names[idx_j] = tmpNames;

    // Swapping scores
    double tmpScores = scores[idx_i];
    scores[idx_i] = scores[idx_j];
    scores[idx_j] = tmpScores;
  }

  /**
   * prt() can print out all students' name with their scores based on what
   * user inputs.
   */
  public static void prt()
  {
    // FOR each students in array:
    for (int i = 0; i < names.length; i++)
      // Print their name with score.
      System.out.printf("     %s  %.1f\n", names[i], scores[i]);
  }

} // End of class
