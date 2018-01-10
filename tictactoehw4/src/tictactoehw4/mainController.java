package tictactoehw4;
import java.util.regex.*;
import java.util.Scanner;


public class mainController {
 final static  int IS_X = 1;
 final static  int IS_O = 0;
 private static int human;
 private static int comp;
 private static final int boardSize = 3;
 private static int humanScore = 0;
 private static int compScore = 0;

 public static void main(String[] args) {
  int turn = 0;
  boolean end = false;
  Scanner scanner = new Scanner(System.in);


  while (!end) {
   //human goes first
   if (turn % 2 == 0) {
    if (humanFirst(scanner) == 1) {
     printScore();
     break;
    }
    turn++;

   }
   // computer goes first
   else {
    if (compFirst(scanner) == 1) {
     printScore();
     break;
    }
    turn++;
   }

  }
  System.out.println("game ended thanks for playing");
 }
 static int humanFirst(Scanner scanner) {
  // return 1 means end the game
  Board board = new Board(boardSize);
  String input;
  int difficulty = 1;
  System.out.println("Welcome to the tictactoe game");
  board.Draw();
  System.out.println("enter the difficulty");
  System.out.println("enter 1 for:Easy");
  System.out.println("enter 2 for:Medium");
  System.out.println("enter 3 for:Hard");
  human = IS_X;
  comp = IS_O;
  AI ai = new AI(comp, boardSize);
  int i = 0;
  while (i < 4) {
   i++;
   input = scanner.next();
   if (input.matches("^([1-3])$")) {
    if (Integer.parseInt(input) == 1) difficulty = 1;
    if (Integer.parseInt(input) == 2) difficulty = 2;
    if (Integer.parseInt(input) == 3) difficulty = 3;
    break;
   } else {

    System.out.println("invalid input! enter number 1 to 3");

   }

  }
  if (i == 4) {
   System.out.println("too many invalid inputs");
   return 1;
  }
  boolean end = false;



  Move move = new Move();
  System.out.println("You go First");
  while (!end) {


   System.out.println("your are X. Enter the coordinate in the format \"x,y\" example. 2,3");


   i = 0;
   while (i < 4) {
    i++;
    input = scanner.next();
    move = getMove(input);
    if (move.getX() == 0 && move.getY() == 0) continue;

    if (!board.addCoorD(move.getX(), move.getY(), human)) continue;
    break;
   }
   if (i == 4) {
    System.out.println("too many invalid inputs");
    return 1;
   }
   board.Draw();
   if (board.checkWin() == -1 || board.checkWin() == human) {
    if (board.checkWin() == -1) {
     System.out.println("DRAW GAME");
    } else {
     System.out.println("YOU WON :) ");
     humanScore++;
    }
    printScore();
    System.out.println("new game? 1 for yes: 0 for no");
    i = 0;
    while (i < 4) {
     i++;
     input = scanner.next();
     if (input.matches("^([0-1])$")) {
      if (Integer.parseInt(input) == 0) {
       return 1;
      } else {
       return 0;
      }
     } else {
      System.out.println("invalid input! enter 1 or 0");
     }
    }
    if (i == 4) {
     System.out.println("too many invalid inputs");
     return 1;
    }
   }
   System.out.println("Computer is thinking");
   move = ai.calculateMove(difficulty, board);
   board.addCoorD(move.getX(), move.getY(), comp);
   board.Draw();
   System.out.println("Computer played " + move.getX() + "," + move.getY());
   if (board.checkWin() == -1 || board.checkWin() == comp) {
    if (board.checkWin() == -1) {
     System.out.println("DRAW GAME");
    } else {
     System.out.println("COMPUTER WON :( ");
     compScore++;
    }
    printScore();
    System.out.println("new game? 1 for yes: 0 for no");
    i = 0;
    while (i < 4) {
     i++;
     input = scanner.next();
     if (input.matches("^([0-1])$")) {
      if (Integer.parseInt(input) == 0) {
       return 1;
      } else {
       return 0;
      }
     } else {
      System.out.println("invalid input! enter 1 or 0");
     }
    }
    if (i == 4) {
     System.out.println("too many invalid inputs");
     return 1;
    }
   } else continue;
  }
  return 1;
 }
 static int compFirst(Scanner scanner) {
  Board board = new Board(boardSize);
  int difficulty = 1;
  String input;
  boolean valid = false;
  System.out.println("Welcome to the tictactoe game");
  board.Draw();
  System.out.println("enter the difficulty");
  System.out.println("enter 1 for:Easy");
  System.out.println("enter 2 for:Medium");
  System.out.println("enter 3 for:Hard");
  human = IS_O;
  comp = IS_X;
  AI ai = new AI(comp, boardSize);
  int i = 0;
  while (i < 4) {
   i++;
   input = scanner.next();
   if (input.matches("^([1-3])$")) {
    if (Integer.parseInt(input) == 1) difficulty = 1;
    else if (Integer.parseInt(input) == 2) difficulty = 2;
    else if (Integer.parseInt(input) == 3) difficulty = 3;
    break;
   } else {
    System.out.println("invalid input! enter number 1 to 3");
   }
  }
  if (i == 4) {
   System.out.println("too many invalid inputs");
   return 1;
  }
  boolean end = false;



  Move move = new Move();
  System.out.println("Computer goes first");
  while (!end) {
   valid = false;

   System.out.println("Computer is thinking");
   move = ai.calculateMove(difficulty, board);
   board.addCoorD(move.getX(), move.getY(), comp);
   System.out.println("Computer played " + move.getX() + "," + move.getY());
   board.Draw();
   if (board.checkWin() == -1 || board.checkWin() == comp) {
    if (board.checkWin() == -1) {
     System.out.println("DRAW GAME");
    } else {
     System.out.println("COMPUTER WON :( ");
     compScore++;
    }
    printScore();
    System.out.println("new game? 1 for yes: 0 for no");
    i = 0;
    while (i < 4) {
     i++;
     input = scanner.next();
     if (input.matches("^([0-1])$")) {

      if (Integer.parseInt(input) == 0) {
       return 1;
      } else {
       return 0;
      }
     } else {
      System.out.println("invalid input! enter 1 or 0");
     }
    }
    if (i == 4) {
     System.out.println("too mane invalid inputs");
     return 1;
    }
   }
   System.out.println("your are O. Enter the coordinate in the format \"x,y\" example. 2,3");
   i = 0;
   while (i < 4) {
    i++;
    input = scanner.next();
    move = getMove(input);
    if (move.getX() == 0 && move.getY() == 0) continue;

    if (!board.addCoorD(move.getX(), move.getY(), human)) continue;
    break;
   }
   if (i == 4) {
    System.out.println("too many invalid inputs");
    return 1;
   }
   board.Draw();
   if (board.checkWin() == -1 || board.checkWin() == human) {
    if (board.checkWin() == -1) {
     System.out.println("DRAW GAME");
    } else {
     System.out.println("YOU WON :) ");
     humanScore++;
    }
    printScore();
    System.out.println("new game? 1 for yes: 0 for no");
    i = 0;
    while (i < 4) {
     i++;
     input = scanner.next();
     if (input.matches("^([0-1])$")) {
      if (Integer.parseInt(input) == 0) {
       return 1;
      } else {
       return 0;
      }
     } else {
      System.out.println("invalid input! enter 1 or 0");
     }
    }
    if (i == 4) {
     System.out.println("too many invalid inputs");
     return 1;
    }
   } else continue;
  }
  return 0;
 }
 static Move getMove(String input) {
  Move move = new Move();
  String regex = "^([1-9]{1,2}[,][1-9]{1,2})$";

  String[] parts = new String[2];
  if (input.matches(regex)) {
   parts = input.split(",");
   int x = Integer.parseInt(parts[0]);
   int y = Integer.parseInt(parts[1]);

   if (x <= boardSize && y <= boardSize) {
    move.setX(x);
    move.setY(y);
    return move;
   }
   System.out.println("invalid move try again");
   return move;
  } else {
   System.out.println("invalid move try again");
   return move;
  }


 }
 static void printScore() {
  System.out.println("Score is you:" + " " + humanScore + " " + "computer" + " " + compScore);
 }
}