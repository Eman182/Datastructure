package myCalculator;
public class calculate implements ICalculator {
public int add(int x,int y) {
	return x+y;
}
public float divide(int x,int y) {
	try {
	    return ((float)x) / y;
	} catch (ArithmeticException e) {
	    throw new ArithmeticException("Division by 0");
	}
}
}
