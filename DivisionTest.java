package myCalculator;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class DivisionTest {
	@Test
	void test() {
		calculate x=new calculate();
		float z=1/3;
		assertEquals(2.5, x.divide(5, 2));
		assertEquals(0, x.divide(0, 2));
		assertEquals(10, x.divide(20, 2));
		assertEquals(z, x.divide(1,3),Math.abs(z-x.divide(1, 3)) );
		{
		 try{
	            x.divide(1, 0);
	            System.err.println("Expected ArithmeticException");
	        } catch(ArithmeticException e) {
	        	
	        }
		}
		{
	{
}
		 }
}
}