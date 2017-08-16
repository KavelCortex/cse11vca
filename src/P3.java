
/**
 * Assignment 03 login: cs11vca This program is to help sorting and analyzing
 * students' score with their names.
 **/
import java.util.Scanner;

/**
 * class P3
 * 
 **/
public class P3
{
  private final static String MENU_STR = "   ===================================\n"
      + "    1  Ascending  Sort of Scores\n"
      + "    2  Descending Sort of Scores\n"
      + "    3  Ascending  Sort of Names\n"
      + "    4  Descending Sort of Names\n"
      + "    5  Above Average Scores with Names\n"
      + "    6  Below Average Scores with Names\n" + "   -1  EXIT\n"
      + "   ===================================\n";

  // Array of scores of students
  private static double[]     scores;

  // Array of names of students
  private static String[]     names;

  // Read input from keyboard
  private static Scanner      scan     = new Scanner(System.in);

  /**
   * 
   **/
  public static void main(String[] args)
  {
    int numStudents; // Number Of Students
    int typeOfSort; // Which type of sort

    do
    {
      typeOfSort = menu();
      if (typeOfSort == -1)
        break;
      System.out.print("Enter the number of students: ");
      numStudents = scan.nextInt();

      names = new String[numStudents];
      scores = new double[numStudents];

      readInput();

      switch (typeOfSort)
      {
        case 1:
          selectionAscendScore();
          prt();
          break;
        case 2:
          bubbleDescendScore();
          prt();
          break;
        case 3:
          bubbleAscendString();
          prt();
          break;
        case 4:
          bubbleDescendString();
          prt();
          break;
        case 5:
          aboveAverage();
          break;
        case 6:
          belowAverage();
          break;
        default:
          System.out.println("odd."); // odd.
      }
    } while (true);
    scan.close();
    System.exit(0);
  }

  public static int menu()
  {
    while (true)
    {
      int userInput = 0;
      System.out.println(MENU_STR);
      System.out.print("Choose type of sort (1 2 3 4 5 6): ");
      userInput = scan.nextInt();
      if (userInput >= -1 && userInput <= 6 && userInput != 0)
        return userInput;
      System.out.println("ERROR! Types only (1 2 3 4 5 6), -1 to exit");
    }
  }

  public static void readInput()
  {
    for (int i = 0; i < names.length; i++)
    {
      System.out.printf("Enter student name  #%d: ", i + 1);
      names[i] = scan.next();

      System.out.printf("Enter student score #%d: ", i + 1);
      scores[i] = scan.nextInt();
    }
  }

  public static void selectionAscendScore()
  {
    double min;
    int minIndex;

    for (int i = 0; i < scores.length; i++)
    {

      min = scores[i];
      minIndex = i;
      for (int j = i + 1; j < scores.length; j++)
      {

        int bias = names[i].compareTo(names[j]);

        if ((min > scores[j]) || (min == scores[j] && bias > 0))
        {
          min = scores[j];
          minIndex = j;
        }

      }
      if (minIndex != i)
        swap(i, minIndex);
    }
  }

  /**
   * The reason for doing sorting twice is because it need to ensure that when
   * one sorting parameter is equal (like two students with the same scores),
   * another parameter (like, the name of two students) remains sorted. And for
   * packing similar methods (like ascending and descending) into single method
   * is just for code efficiency.
   **/
  public static void bubbleDescendScore()
  {
    bubbleString(false);
    bubbleScore(false);
  }

  public static void bubbleAscendString()
  {
    bubbleScore(true);
    bubbleString(true);
  }

  public static void bubbleDescendString()
  {
    bubbleScore(false);
    bubbleString(false);
  }

  public static void aboveAverage()
  {
    selectionAscendScore();
    double avg = average();

    System.out.println("     ABOVE AVERAGE STUDENTS");

    int idx;
    for (idx = 0; scores[idx] < avg; idx++)
      ;
    for (int i = idx; i < scores.length; i++)
      System.out.printf("     %s  %.2f\n", names[i], scores[i]);
  }

  public static void belowAverage()
  {
    bubbleDescendScore();
    double avg = average();

    System.out.println("     BELOW AVERAGE STUDENTS");

    int idx;
    for (idx = 0; scores[idx] > avg; idx++)
      ;
    for (int i = idx; i < scores.length; i++)
      System.out.printf("     %s  %.2f\n", names[i], scores[i]);
  }

  public static void swap(int idx_i, int idx_j)
  {

    String tmpNames = names[idx_i];
    names[idx_i] = names[idx_j];
    names[idx_j] = tmpNames;

    double tmpScores = scores[idx_i];
    scores[idx_i] = scores[idx_j];
    scores[idx_j] = tmpScores;
  }

  public static void prt()
  {
    for (int i = 0; i < names.length; i++)
      System.out.printf("     %s  %.2f\n", names[i], scores[i]);
  }

  public static double average()
  {
    double avg = 0;
    for (int i = 0; i < scores.length; i++)
      avg += scores[i];
    avg = avg / scores.length;

    System.out.printf("     AVERAGE score: %.2f\n", avg);
    return avg;
  }

  public static void bubbleScore(boolean isAscend)
  {
    for (int i = 0; i < scores.length; i++)
      for (int j = scores.length - 1; j > i; j--)
        if (isAscend ? (scores[j - 1] > scores[j])
            : (scores[j - 1] < scores[j]))
          swap(j - 1, j);
  }

  public static void bubbleString(boolean isAscend)
  {
    for (int i = 0; i < names.length; i++)
      for (int j = names.length - 1; j > i; j--)
      {
        int comparison = names[j - 1].compareTo(names[j]);
        if (isAscend ? (comparison > 0) : (comparison < 0))
          swap(j - 1, j);
      }
  }

}
