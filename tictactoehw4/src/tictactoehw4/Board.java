package tictactoehw4;

public class Board {

 private char X = 'X';
 private char O = 'O';
 private String horizontalDraw = "+ - ";
 private String verticalDraw = "| ";
 private int size;
 private char[][] coorD = new char[size + 2][size + 2];;
 public Board(int size) {
  coorD = new char[size + 1][size + 1];;
  this.size = size;
  for (int x = 1; x < this.size + 1; x++) {
   for (int y = 1; y < this.size + 1; y++) {
    coorD[x][y] = Character.MIN_VALUE;
   }
  }
 }
 public void Draw() {
  int height = 0;
  for (int i = 0; i < size; i++) {
   System.out.print("  ");
   System.out.print(i + 1 + " ");
  }
  System.out.print("----> X" + "\n");
  while (height < size) {

   for (int i = 0; i < size; i++) {
    System.out.print(horizontalDraw);

   }
   System.out.print('+' + "\n");
   for (int i = 0; i < size; i++) {
    if (coorD[i + 1][height + 1] == Character.MIN_VALUE)
     System.out.print(verticalDraw + "  ");
    else System.out.print(verticalDraw + coorD[i + 1][height + 1] + " ");
   }
   System.out.print('|');
   System.out.print(height + 1 + "\n");
   height++;
  } //end of while
  for (int i = 0; i < size; i++) {
   System.out.print(horizontalDraw);

  }
  System.out.print('+');
  System.out.print('|');
  System.out.println('Y');
  System.out.println(" ");
 }
 public int checkWin() {
   // x wins return 1 o wins return 0 tie return -1  still in game return 2
   // check collumns
   int xCounter = 0;
   int oCounter = 0;

   for (int x = 1; x < size + 1; x++) {
    xCounter = 0;
    oCounter = 0;
    for (int y = 1; y < size + 1; y++) {
     if (coorD[x][y] == Character.MIN_VALUE) break;
     else
     if (coorD[x][y] == O) {
      oCounter++;
      if (oCounter == size) return 0;
     } else
     if (coorD[x][y] == X) {
      xCounter++;
      if (xCounter == size) return 1;
     }

     if (xCounter > 0 && oCounter > 0) break;

    }

   }
   // check rows
   for (int y = 1; y < size + 1; y++) {
    xCounter = 0;
    oCounter = 0;
    for (int x = 1; x < size + 1; x++) {
     if (coorD[x][y] == Character.MIN_VALUE) break;
     else
     if (coorD[x][y] == O) {
      oCounter++;
      if (oCounter == size) return 0;
     } else
     if (coorD[x][y] == X) {
      xCounter++;
      if (xCounter == size) return 1;
     }

     if (xCounter > 0 && oCounter > 0) break;

    }

   }
   // check diagonal "\"
   xCounter = 0;
   oCounter = 0;
   for (int y = 1; y < size + 1; y++) {

    for (int x = 1; x < size + 1; x++) {

     if (x == y) {
      if (coorD[x][y] == Character.MIN_VALUE) break;
      else
      if (coorD[x][y] == O) {
       oCounter++;
       if (oCounter == size) return 0;
      } else
      if (coorD[x][y] == X) {
       xCounter++;
       if (xCounter == size) return 1;
      }

      if (xCounter > 0 && oCounter > 0) break;
     }
    }

   }
   //check the "/" diagonal
   xCounter = 0;
   oCounter = 0;
   int x = 1;
   for (int y = size; y > 0; y--) {

    if (coorD[x][y] == Character.MIN_VALUE) break;
    else
    if (coorD[x][y] == O) {
     oCounter++;
     if (oCounter == size) return 0;
    } else
    if (coorD[x][y] == X) {
     xCounter++;
     if (xCounter == size) return 1;
    }

    if (xCounter > 0 && oCounter > 0) break;

    x++;


   }
   // check tie (board is full but no one wins)
   int counter = 0;
   for (int y = 1; y < size + 1; y++) {
    for (x = 1; x < size + 1; x++) {
     if (coorD[x][y] == Character.MIN_VALUE) break;
     else
     if (coorD[x][y] == O || coorD[x][y] == X) counter++;


    }
   }
   if (counter == size * size) return -1;
   return 2;

  } //end of check win
 public boolean addCoorD(int x, int y, int player) {
  if (coorD[x][y] == Character.MIN_VALUE) {
   if (player == 1) {
    coorD[x][y] = X;
    return true;
   } else {
    coorD[x][y] = O;
    return true;
   }
  }
  System.out.println("spot is taken");
  return false;
 }
 public char getCoorValue(int x, int y) {
  return coorD[x][y];
 }
 public void clearMove(int x, int y) {
  coorD[x][y] = Character.MIN_VALUE;
 }
}