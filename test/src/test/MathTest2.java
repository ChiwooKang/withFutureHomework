package test;

public class MathTest2 {

	public static void main(String args[]) {
		MathTest2 mathtest = new MathTest2();
		System.out.println(mathtest.divide("dkdkdk"));
	}
	
	
	public double divide(String a) {
		Mathtest mathtest = new Mathtest();
		double return_value = 0;
		
		try {
			return_value = mathtest.divide(a);
			}catch (NumberFormatException e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}
		return return_value;	
	}
	
}
