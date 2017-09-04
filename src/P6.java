
/**
 * Assignment 6
 * 
 * login: cs11vca
 * 
 * This program is an JavaFX GUI application displays a deck of playing
 * card. User can shuffle, sort in different orders by clicking buttons.
 * 
 * 
 **/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import java.util.Random;

/**
 * class P6
 * 
 * This class is the main class for the program. Inherited form Application
 * meaning that this is an JavaFX Application.
 * 
 * @author cs11vca
 * @version 1.0
 **/
public class P6 extends Application
{
  /**
   * the directory where card images are holding.
   **/
  private static final String CARD_DIR      =
      "file:/home/linux/ieng6/cs11v/public/image/card/";

  /**
   * the filetype of the card image.
   */
  private static final String CARD_FILETYPE = ".png";

  /**
   * the size of all cards.
   */
  private static final int    ASIZE         = 54;

  /**
   * how many rows of card to display.
   */
  private static final int    ROWS          = 6;

  /**
   * how many columns of card to display.
   */
  private static final int    COLS          = 9;

  /**
   * the number of cards in one set
   */
  private static final int    SET_NUM       = 13;

  /**
   * the number of cards in a standard deck (without jokers)
   */
  private static final int    DECK_NUM      = 52;

  /**
   * how many number of cards in one hand
   */
  private static final int    DEAL_NUM      = 5;

  /**
   * how many hands to deal
   */
  private static final int    DEAL_HANDS    = 2;

  /**
   * initialize a placeholder for card indices.
   */
  private int                 aCardDeck[]   = new int[ASIZE];

  /**
   * start method from Application initialize any elements to be shown on
   * GUI.
   * 
   * @param primaryStage
   *          Passes in a stage which is the top level of the JavaFX
   *          container. elements must be added on primaryStage to be
   *          displayed.
   **/
  public void start(Stage primaryStage)
  {
    int i, j, k; // initialize indices

    // load the indices of card image into the array.
    for (i = 0; i < ASIZE; i++)
      aCardDeck[i] = i + 1;

    // generate a panel for showing cards
    GridPane gPane = new GridPane();
    // In each cell from the panel,
    for (i = k = 0; i < ROWS && k < ASIZE; i++)
      for (j = 0; j < COLS; j++)
        // Load an card image by indices from the array.
        gPane.add(new ImageView(CARD_DIR + aCardDeck[k++] + CARD_FILETYPE), j,
            i);

    // Initializing Ascending Sort Button
    Button btAscSort = new Button("Ascend Sort");
    btAscSort.setOnAction(e ->
    {
      // indices for displaying cards
      int r, c, n;

      // Perform the sort on aCardDeck
      ascendSort();

      // remove every cards from the screen
      gPane.getChildren().clear();

      // Add cards by a new order using aCardDeck array.
      for (r = n = 0; r < ROWS && n < ASIZE; r++)
        for (c = 0; c < COLS; c++)
          gPane.add(new ImageView(CARD_DIR + aCardDeck[n++] + CARD_FILETYPE),
              c, r);
    });

    // Initializing Descending Sort Button
    Button btDescSort = new Button("Descend Sort");
    btDescSort.setOnAction(e ->
    {
      // indices for displaying cards
      int r, c, n;

      // Perform the sort on aCardDeck
      descendSort();

      // remove every cards from the screen
      gPane.getChildren().clear();

      // Add cards by a new order using aCardDeck array.
      for (r = n = 0; r < ROWS && n < ASIZE; r++)
        for (c = 0; c < COLS; c++)
          gPane.add(new ImageView(CARD_DIR + aCardDeck[n++] + CARD_FILETYPE),
              c, r);
    });

    // Initializing Shuffle Button
    Button btShuffle = new Button("Shuffle");
    btShuffle.setOnAction(e ->
    {
      // indices for displaying cards
      int r, c, n;

      // Perform a shuffle on aCardDeck
      shuffle();

      // remove every cards from the screen
      gPane.getChildren().clear();

      // Add cards by a new order using aCardDeck array.
      for (r = n = 0; r < ROWS && n < ASIZE; r++)
        for (c = 0; c < COLS; c++)
          gPane.add(new ImageView(CARD_DIR + aCardDeck[n++] + CARD_FILETYPE),
              c, r);
    });

    // Initializing Ascend Rank Sort Button
    Button btAscRank = new Button("Ascend Rank");
    btAscRank.setOnAction(e ->
    {
      // indices for displaying cards
      int r, c, n;

      // Perform the sort on aCardDeck
      ascendRankSort();

      // remove every cards from the screen
      gPane.getChildren().clear();

      // Add cards by a new order using aCardDeck array.
      for (r = n = 0; r < ROWS && n < ASIZE; r++)
        for (c = 0; c < COLS; c++)
          gPane.add(new ImageView(CARD_DIR + aCardDeck[n++] + CARD_FILETYPE),
              c, r);
    });

    // Initializing Descend Rank Sort Button
    Button btDescRank = new Button("Descend Rank");
    btDescRank.setOnAction(e ->
    {
      // indices for displaying cards
      int r, c, n;

      // Perform the sort on aCardDeck
      descendRankSort();

      // remove every cards from the screen
      gPane.getChildren().clear();

      // Add cards by a new order using aCardDeck array.
      for (r = n = 0; r < ROWS && n < ASIZE; r++)
        for (c = 0; c < COLS; c++)
          gPane.add(new ImageView(CARD_DIR + aCardDeck[n++] + CARD_FILETYPE),
              c, r);
    });

    // Initializing Deal Button
    Button btDeal = new Button("Deal");
    btDeal.setOnAction(e ->
    {
      // indices for displaying cards
      int r, c, n;

      // Perform a shuffle on aCardDeck
      shuffle();

      // remove every cards from the screen
      gPane.getChildren().clear();

      // Add cards by a new order using aCardDeck array.
      // which shows a 2-by-5 shuffled card set.
      for (r = n = 0; r < DEAL_HANDS && n < ASIZE; r++)
        for (c = 0; c < DEAL_NUM; c++)
          gPane.add(new ImageView(CARD_DIR + aCardDeck[n++] + CARD_FILETYPE),
              c, r);
    });

    // Initializing Exit Button
    Button btExit = new Button("Exit");
    btExit.setOnAction(e ->
    {
      Platform.exit(); // Closing Window
      System.exit(0); // Terminating program
    });

    // Initializing a horizontal box for 7 buttons
    HBox hbox = new HBox(7);
    // glue on 7 buttons
    hbox.getChildren().add(btAscSort);
    hbox.getChildren().add(btDescSort);
    hbox.getChildren().add(btShuffle);
    hbox.getChildren().add(btAscRank);
    hbox.getChildren().add(btDescRank);
    hbox.getChildren().add(btDeal);
    hbox.getChildren().add(btExit);

    // Initializing GUI layout
    BorderPane pane = new BorderPane();
    // put gPane to the center of the window
    pane.setCenter(gPane);
    // put hbox to the bottom of the window
    pane.setBottom(hbox);
    // set alignment for the hbox
    BorderPane.setAlignment(hbox, Pos.CENTER);

    // initializing a new scene determines the window size to be 650x600
    // by gluing the layout
    Scene scene = new Scene(pane, 650, 600);

    // set the title of the window
    primaryStage.setTitle("P6");
    // set the scene to the stage
    primaryStage.setScene(scene);
    // showtime
    primaryStage.show();

  }

  /**
   * main() is the main entrance of the whole program.
   * 
   * @param args
   *          passing user input to the launching process.
   *
   */
  public static void main(String[] args)
  {
    // calling launch() from Application to begin the GUI generating
    // process.
    launch(args);
  }

  /**
   * ascendSort() modify the order in aCardDeck to ascend.
   **/
  public void ascendSort()
  {
    // Sorting ranges from the first element to the end. Each iteration
    // leaves out the first element from the rest of the array because
    // that one is well sorted.
    for (int i = 0; i < aCardDeck.length; i++)
      // Sorting progress begins from the end of the array to the sorting
      // boundary.
      for (int j = aCardDeck.length - 1; j > i; j--)
      {
        // If the next element is bigger than this one,
        if (aCardDeck[i] > aCardDeck[j])
          swap(i, j); // Swap two elements.
      }
  }

  /**
   * descendSort() modify the order in aCardDeck to descend.
   **/
  public void descendSort()
  {
    for (int i = 0; i < aCardDeck.length; i++)
      for (int j = aCardDeck.length - 1; j > i; j--)
      {
        // If the next element is bigger than this one,
        if (aCardDeck[i] < aCardDeck[j])
          swap(i, j);// Swap two elements.
      }
  }

  /**
   * ascendRankSort() modify the order in aCardDeck to ascend by Rank.
   **/
  public void ascendRankSort()
  {
    for (int i = 0; i < aCardDeck.length; i++)
      for (int j = aCardDeck.length - 1; j > i; j--)
      {
        // We split the whole deck into 2 decks, which the first one is the
        // standard 52 card deck, while the second one is the joker-only
        // deck.

        // decki and deckj indicates which deck they belong to by
        // subtracted by 1 and then divided by 52.
        int decki = (aCardDeck[i] - 1) / DECK_NUM;
        int deckj = (aCardDeck[j] - 1) / DECK_NUM;

        // As for the standard 52 card deck, we split them into 4 sets, so
        // each set contains card from A to K ranking by 1 to 13, and each
        // set has different Suits.

        // ranki and rankj indicates which rank they are by subtracted by 1
        // and then mod by 13.
        int ranki = (aCardDeck[i] - 1) % SET_NUM;
        int rankj = (aCardDeck[j] - 1) % SET_NUM;

        // if deck is higher, or deck is the same, but rank is higher, or
        // deck and rank is the same, but the indices is higher (which is
        // caused by two cards has different Suit),
        if (decki > deckj || (decki == deckj && ranki > rankj)
            || (decki == deckj && ranki == rankj
                && aCardDeck[i] > aCardDeck[j]))
          swap(i, j); // Swap two cards.
      }
  }

  /**
   * descendRankSort() modify the order in aCardDeck to descend by Rank.
   **/
  public void descendRankSort()
  {
    for (int i = 0; i < aCardDeck.length; i++)
      for (int j = aCardDeck.length - 1; j > i; j--)
      {
        // calculate deck indices and rank indices of the cards.
        int decki = (aCardDeck[i] - 1) / DECK_NUM;
        int deckj = (aCardDeck[j] - 1) / DECK_NUM;
        int ranki = (aCardDeck[i] - 1) % SET_NUM;
        int rankj = (aCardDeck[j] - 1) % SET_NUM;

        // if deck is lower, or deck is the same, but rank is lower, or
        // deck and rank is the same, but the indices is lower (which is
        // caused by two cards has different Suit),
        if (decki < deckj || (decki == deckj && ranki < rankj)
            || (decki == deckj && ranki == rankj
                && aCardDeck[i] < aCardDeck[j]))
          swap(i, j);// Swap two cards.
      }
  }

  /**
   * shuffle() shuffles the indices by exchanging each of the elements to a
   * element which location is random.
   **/
  public void shuffle()
  {

    // Initialize the random generator.
    Random rand = new Random(System.currentTimeMillis());
    // for each elements in aCardDeck
    for (int i = 0; i < aCardDeck.length; i++)
    {
      // generate a randomized location (within ASIZE)
      int r = rand.nextInt(ASIZE);
      swap(i, r);// Swap two indices.
    }
  }

  /**
   * swap() swap two elements in aCardDeck.
   * 
   * @param j
   *          the first index
   * @param k
   *          the second index
   *
   */
  public void swap(int j, int k)
  {
    int temp = aCardDeck[j];
    aCardDeck[j] = aCardDeck[k];
    aCardDeck[k] = temp;
  }

}// End of class
