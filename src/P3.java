
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
      }

    } while (true);
  }

  public static int menu()
  {
    System.out.println(MENU_STR);
    System.out.print("Choose type of sort (1 2 3 4 5 6): ");

    return scan.nextInt();
  }

  public static void readInput()
  {
    for (int i = 0; i < names.length; i++)
    {
      System.out.printf("Enter student name  #%d: ", i);
      names[i] = scan.next();

      System.out.printf("Enter student score #%d", i);
      scores[i] = scan.nextInt();
    }
  }

  /**
   * The reason we do sorting twice is because we need to ensure that when one
   * sorting parameter is equal (like two student with the same scores),
   * another parameter (like, the name of the student) remains sorted. 
   * And we pack similar sorting methods (like ascending and descending)
   * into single method just for code efficiency.
   **/
  public static void selectionAscendScore()
  {
    selectionString(true);
    selectionScore(true);
  }

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
    
  }

  public static void belowAverage()
  {

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

  }

  public static void bubbleScore(boolean isAscend)
  {
    for (int i = 0; i < scores.length; i++)
      for (int j = scores.length; j > i; j--)
        if (isAscend ? (scores[j - 1] > scores[j])
            : (scores[j - 1] < scores[j]))
          swap(j - 1, j);
  }

  public static void bubbleString(boolean isAscend)
  {
    for (int i = 0; i < names.length; i++)
      for (int j = names.length; j > i; j--)
      {
        int comparison = names[j - 1].compareTo(names[j]);
        if (isAscend ? (comparison > 0) : (comparison < 0))
          swap(j - 1, j);
      }
  }

  public static void selectionScore(boolean isAscend)
  {
    double m; // m is for min/max. We compress them into one method.
    int mIndex; // The index of m

    for (int i = 0; i < scores.length; i++)
    {
      m = scores[i];
      mIndex = i;
      for (int j = i + 1; j < scores.length; j++)
      {
        if (isAscend ? (m > scores[j]) : (m < scores[j]))
        {
          m = scores[j];
          mIndex = j;
        }
      }
      if (mIndex != i)
        swap(i, mIndex);
    }
  }

  public static void selectionString(boolean isAscend)
  {
    String m; // m is for min/max. We compress them into one method.
    int mIndex; // The index of m

    for (int i = 0; i < names.length; i++)
    {
      m = names[i];
      mIndex = i;
      for (int j = i + 1; j < names.length; j++)
      {
        int comparison = m.compareTo(names[j]);
        if (isAscend ? (comparison > 0) : (comparison < 0))
        {
          m = names[j];
          mIndex = j;
        }
      }
      if (mIndex != i)
        swap(i, mIndex);
    }
  }

}
