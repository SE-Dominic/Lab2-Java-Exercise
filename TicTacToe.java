import java.util.Scanner; //scanner for user input
enum Status {
  WIN, DRAW, CONTINUE
}

public class TicTacToe {
  private final int BOARDSIZE = 3;
  private Status status;
  private char board[][] = new char[BOARDSIZE][BOARDSIZE];
  private boolean firstPlayer = true;
  private boolean gameOver = false;
  

  public void play() { 
    //game started
    //fill matrix with empty spaces
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
          board[i][j] = ' ';
      }
    }
     
    Scanner input = new Scanner(System.in);
    printBoard(); //prints the board
    
    //play game loop
    while (gameOver == false) {
      int row, col; //row and column for the move
      String player = (firstPlayer) ? "Player 1" : "Player 2"; //determine player string based on firstPlayer boolean
      char tileChar = (firstPlayer) ? 'x' : 'o';

      System.out.println(player + "'s turn.");
      System.out.println("Enter row: ");
      row = input.nextInt() - 1;
      System.out.println("Enter column: ");
      col = input.nextInt() - 1;


      //check if their move is valid
      if (validMove(row, col)) {
        board[row][col] = tileChar; //place an x on the board
        printBoard(); //print the board
        //printStatus(); //print the status of the game
        firstPlayer = !firstPlayer; //change to player 2's turn
      } else {
        System.out.println("Invalid move. Try again.");
      }
      
      
    } //end of while loop
    input.close(); //close scanner
    System.out.println("Thank you for playing our game!");
  }

  public void printBoard(){
    //print board
    System.out.println(" _______________________ ");

    //fill board with matrix charactres
    for (int i = 0; i < BOARDSIZE; i++) {
      System.out.println("|       |       |       |");
      System.out.print("|   ");

      for (int j = 0; j < BOARDSIZE; j++) {
        String output = printSymbol(i, j) + "   |   ";
        System.out.print(output);
      }

      System.out.println("\n|_______|_______|_______|");
    }
  }
  /*
  private void printStatus() {

    switch(status){
      case WIN: 
          System.out.println("Player " + (firstPlayer ? "x" : "o") + "wins.");
          break;
      case DRAW:
          System.out.println("Draw.");
          break;
      case CONTINUE:
          System.out.println("Player " + (firstPlayer ? "x" : "o") + "'s turn.");
          break;
    }

  }
   */
  
  //function checks to see if the move they made is valid
  public boolean validMove(int row, int col) {
    if ((row <= 2 && row >= 0) && (col >= 0  && col <= 2)) {
      if(board[row][col] == ' ')
      return true;
    }
    return false; 
  }
  
  private char printSymbol(int row, int column) {
    char output;
    if (firstPlayer = true){
      output = 'x';
      output = board[row][column];
    } else {
      output = 'o';
      output = board[row][column];
    }
    return output;
}
  private boolean checkWin() {
    //check rows
    for (int i = 0; i < BOARDSIZE; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        if (board[i][0] == 'x') {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
        return true;
      }
    }
    //check columns
    for (int i = 0; i < BOARDSIZE; i++) {
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        if (board[0][i] == 'x') {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
        return true;
      }
    }
    //check diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      if (board[0][0] == 'x') {
        System.out.println("Player 1 wins.");
      } else {
        System.out.println("Player 2 wins.");
      }
      return true;
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      if (board[0][2] == 'x') {
        System.out.println("Player 1 wins.");
      } else {
        System.out.println("Player 2 wins.");
      }
      return true;
    }
    return false;
  }

}
