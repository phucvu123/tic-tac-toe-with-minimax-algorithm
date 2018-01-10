package testProgram;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import tictactoehw4.Board;
public class BoardTest {
       Board board = new Board(3);
	int is_x =1;
	int is_o=0;
	@Test
	public void addCoordinate() {
		 
	        Assert.assertTrue(board.addCoorD(1, 1, is_x));
		Assert.assertTrue(board.getCoorValue(1, 1)=='X');
		Assert.assertFalse(board.addCoorD(1, 1, is_x));
		
		Assert.assertTrue(board.addCoorD(1, 2, is_o));
		Assert.assertTrue(board.getCoorValue(1, 2)=='O');
		Assert.assertFalse(board.addCoorD(1, 1, is_o));
	}
       @Test
	public void clearMoveTest() {
		board.addCoorD(3, 3, is_x);
		board.clearMove(3, 3);
		Assert.assertTrue(board.getCoorValue(1, 1)==Character.MIN_VALUE);
	}
       @Test
	public void checkWinCollumns() {
		Board board2 = new Board(3);
		board2.addCoorD(1, 1, is_x);
		board2.addCoorD(1, 2, is_x);
		board2.addCoorD(1, 3, is_x);
		Assert.assertTrue(board2.checkWin()==1);
               Board board3 = new Board(3);
		board3.addCoorD(1, 1, is_x);
		board3.addCoorD(1, 2, is_o);
		board3.addCoorD(1, 3, is_x);
		Assert.assertFalse(board3.checkWin()==1);
	        Board board4 = new Board(3);
		board4.addCoorD(2, 1, is_x);
		board4.addCoorD(2, 2, is_x);
		board4.addCoorD(2, 3, is_x);
		Assert.assertTrue(board4.checkWin()==1);
		
	}
	@Test
	public void checkWinrows() {
		Board board2 = new Board(3);
		board2.addCoorD(1, 1, is_x);
		board2.addCoorD(2, 1, is_x);
		board2.addCoorD(3, 1, is_x);
		Assert.assertTrue(board2.checkWin()==1);
		Board board3 = new Board(3);
		board3.addCoorD(1, 1, is_x);
		board3.addCoorD(2, 1, is_o);
		board3.addCoorD(3, 1, is_x);
		Assert.assertFalse(board3.checkWin()==1);
		Board board4 = new Board(3);
		board4.addCoorD(1, 3, is_x);
		board4.addCoorD(2, 3, is_x);
		board4.addCoorD(3, 3, is_x);
	    Assert.assertTrue(board4.checkWin()==1);
 
		
	}
         @Test
	public void checkdiagonal() {
		Board board2 = new Board(3);
		board2.addCoorD(1, 1, is_o);
		board2.addCoorD(2, 2, is_o);
		board2.addCoorD(3, 3, is_o);
		Assert.assertTrue(board2.checkWin()==0);
		Board board3 = new Board(3);
		board3.addCoorD(1, 1, is_x);
		board3.addCoorD(2, 2, is_o);
		board3.addCoorD(3, 3, is_x);
		Assert.assertFalse(board3.checkWin()==1);
	}
        @Test
	public void checkReverseDiagonal() {
		Board board2 = new Board(3);
		board2.addCoorD(3, 1, is_o);
		board2.addCoorD(2, 2, is_o);
		board2.addCoorD(1, 3, is_o);
		Assert.assertTrue(board2.checkWin()==0);
		Board board3 = new Board(3);
		board3.addCoorD(3, 1, is_x);
		board3.addCoorD(2, 2, is_o);
		board3.addCoorD(1, 3, is_x);
		Assert.assertFalse(board3.checkWin()==0);
	}
          @Test
	public void checkTie() {
		Board board2 = new Board(3);
		board2.addCoorD(1, 1, is_o);
		board2.addCoorD(1, 2, is_o);
		board2.addCoorD(1, 3, is_x);
		board2.addCoorD(2, 1, is_x);
		board2.addCoorD(2, 2, is_x);
		board2.addCoorD(2, 3, is_o);
		board2.addCoorD(3, 1, is_o);
		board2.addCoorD(3, 2, is_x);
		board2.addCoorD(3, 3, is_o);
		Assert.assertTrue(board2.checkWin()==-1);
	}
}
