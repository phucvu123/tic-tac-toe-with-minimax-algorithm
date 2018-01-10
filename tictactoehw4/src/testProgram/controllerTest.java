package testProgram;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import tictactoehw4.Move;
import tictactoehw4.mainController;
public class controllerTest {

	@Test
	public void playerInput() {
		Assert.assertTrue( getmove("1,2") );  
		Assert.assertTrue( getmove("10,20") );  
		Assert.assertFalse( getmove("a,a") ); 
		Assert.assertFalse( getmove("1a,av") ); 
	}

	private boolean getmove(String input) {
		  
		 String regex ="^([0-9]{1,2}[,][0-9]{1,2})$";
		    
		   String [] parts = new String[2];
		   if(input.matches(regex)){
	          return true;
		   }
		   else{
			   return false;
		   }
		    
	}

}
