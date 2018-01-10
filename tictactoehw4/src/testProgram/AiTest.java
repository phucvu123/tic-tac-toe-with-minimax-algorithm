package testProgram;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import tictactoehw4.AI;
import tictactoehw4.Board;
import tictactoehw4.Move;
public class AiTest {
	int is_x =1;
	int is_o=0;
	AI ai = new AI(is_o,3);
	@Test
	public void HardLeveltest() {
		// simulate a game between two hard level computer size 3
		  Board board = new Board(3);
		  board.addCoorD(3, 1,is_x );
		  Move move = ai.calculateMove(3, board);
		  board.addCoorD(move.getX(), move.getY(),is_o );
		  // best move according to hard level tic tac toe online
	      Assert.assertTrue(move.getX()==2&&move.getY()==2);
	      board.addCoorD(1, 1,is_x );
	      move = ai.calculateMove(3, board);
		  board.addCoorD(move.getX(), move.getY(),is_o );
		  Assert.assertTrue(move.getX()==2&&move.getY()==1);
		  board.addCoorD(2, 3,is_x );
		  move = ai.calculateMove(3, board);
		  board.addCoorD(move.getX(), move.getY(),is_o );
		  Assert.assertTrue(move.getX()==1&&move.getY()==2);
		  // game tie now
		  
			AI ai2 = new AI(is_o,5);
		  Board board2 = new Board(5);
		  board2.addCoorD(1, 1,is_x );
		  board2.addCoorD(2, 1,is_x );
		  board2.addCoorD(3, 1,is_x );
		  board2.addCoorD(4, 1,is_x );
		  board2.addCoorD(1, 2,is_o );
		  board2.addCoorD(1, 3,is_o );
		  board2.addCoorD(1, 4,is_o );
		  move = ai2.calculateMove(3, board2);
		  Assert.assertTrue(move.getX()==5&&move.getY()==1);
	}
      @Test
	public void easyLeveltest() {
		  Board board = new Board(3);
		  board.addCoorD(1, 1, is_x);

			AI ai2 = new AI(is_o,3);
			Move temp = ai2.calculateMove(1, board);
			 Assert.assertFalse(temp.getX()==1&&temp.getY()==1);
	}
}
