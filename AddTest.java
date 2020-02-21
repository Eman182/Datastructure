package myCalculator;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class AddTest {
	@Test 
	void test() {
		calculate Add=new calculate();
		int result=Add.add(10, 20);
		int res=Add.add(30,0);
		int result1=Add.add(0, 30);
		assertEquals(30, result);
		assertEquals(30, res);
		assertEquals(30, result1);
	}
}
