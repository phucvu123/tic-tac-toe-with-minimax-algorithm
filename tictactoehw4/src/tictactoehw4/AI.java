package tictactoehw4;
import java.util.ArrayList;
import java.util.List;




public class AI {
 private int comp;
 private int boardSize;
 private int human;
 private Move move;
 private int depth;
 private int computationDepth;
 private final static int computationLimitHard = 10000000;
 private final static int computationLimitMedium = 10000;
 private List < Move > possibleMoves;
 public AI(int player, int size) {
  Move move = new Move();
  this.comp = player;
  this.boardSize = size;
  if (comp == 1) human = 0;
  else human = 1;

  possibleMoves = new ArrayList < Move > ((size * size) + 1);
  for (int x = 1; x < size + 1; x++) {
   for (int y = 1; y < size + 1; y++) {
    Move tempMoves = new Move();
    tempMoves.setX(x);
    tempMoves.setY(y);
    possibleMoves.add(tempMoves);
   }
  }

 }
 public Move calculateMove(int difficulty, Board board) {
  computationDepth = 0;
  depth = 0;
  if (difficulty == 1) return easyLevel(board, comp);
  else if (difficulty == 2) return MiniMax(board, comp, depth, computationLimitMedium);
  else if (difficulty == 3) {
   return MiniMax(board, comp, depth, computationLimitHard);
  } else return MiniMax(board, comp, depth, computationLimitHard);
 }
 private Move easyLevel(Board board, int player) {
  boolean found = false;
  int randomIndex;
  int x = 0;
  int y = 0;
  int numMove = boardSize * boardSize;
  Move temp = new Move();
  while (!found) {
   randomIndex = (int)(Math.random() * numMove + 0);
   x = possibleMoves.get(randomIndex).getX();
   y = possibleMoves.get(randomIndex).getY();

   if (board.getCoorValue(x, y) == Character.MIN_VALUE) {
    temp.setX(x);

    temp.setY(y);

    found = true;
   }

  }
  return temp;
 }

 private Move MiniMax(Board board, int player, int depth, int computationLimit) {


  int win = board.checkWin();
  depth++;
  computationDepth++;
  if (win == comp) {
   Move move = new Move();
   move.setScore(10 - depth);
   return move;
  } else if (win == human) {
   Move move = new Move();
   move.setScore(depth - 10);
   return move;
  } else if (win == -1) {
   Move move = new Move();
   move.setScore(0);
   return move;
  } else if (computationDepth > computationLimit) {
   Move move = new Move();
   move.setScore(0);
   return move;
  }
  List < Move > moves = new ArrayList < Move > ();
  for (Move move: possibleMoves) {
   int x = move.getX();
   int y = move.getY();

   if (board.getCoorValue(x, y) == Character.MIN_VALUE) {
    board.addCoorD(x, y, player);
    Move tempMove = new Move();
    tempMove.setX(x);
    tempMove.setY(y);

    if (player == comp) {

     tempMove.setScore(MiniMax(board, human, depth, computationLimit).getScore());
    } else {
     tempMove.setScore(MiniMax(board, comp, depth, computationLimit).getScore());
    }
    moves.add(tempMove);
    board.clearMove(x, y);

   }

  }
  int bestMove = 0;
  if (player == comp) {
   int bestScore = Integer.MIN_VALUE;

   for (int i = 0; i < moves.size(); i++) {
    if (moves.get(i).getScore() > bestScore) {
     bestScore = moves.get(i).getScore();
     bestMove = i;
    }
   }
  } else {
   int bestScore = Integer.MAX_VALUE;

   for (int i = 0; i < moves.size(); i++) {
    if (moves.get(i).getScore() < bestScore) {
     bestScore = moves.get(i).getScore();
     bestMove = i;
    }
   }

  }
  if (depth == 1&&boardSize>3) {

   board.addCoorD(moves.get(bestMove).getX(), moves.get(bestMove).getY(), comp);
   if (board.checkWin() == comp) {
    board.clearMove(moves.get(bestMove).getX(), moves.get(bestMove).getY());
    Move temp = moves.get(bestMove);
    moves.clear();

    return temp;
   }
   for (Move move: possibleMoves) {
    Move temp = new Move();
    int x = move.getX();
    int y = move.getY();

    if (board.getCoorValue(x, y) == Character.MIN_VALUE) {
     board.addCoorD(x, y, human);
     if (board.checkWin() == human) {
      temp.setX(x);
      temp.setY(y);
      board.clearMove(x, y);
      moves.clear();
      board.clearMove(x, y);

      return temp;
     }
     board.clearMove(x, y);

     board.clearMove(moves.get(bestMove).getX(), moves.get(bestMove).getY());
    }

   }
   board.clearMove(moves.get(bestMove).getX(), moves.get(bestMove).getY());
  }
  Move temp = moves.get(bestMove);
  moves.clear();

  return temp;

 }
}