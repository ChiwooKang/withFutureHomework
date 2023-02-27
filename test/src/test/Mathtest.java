package test;

public class Mathtest {

	public double divide (String a) throws NumberFormatException{
		
		double return_value = 0;
		
//		try {
//			return_value = Math.sqrt(Double.parseDouble(a));	
//		}catch (NumberFormatException e) {
//			System.out.println(e);
//			System.out.println(e.getStackTrace());
//		}
		return_value = Math.sqrt(Double.parseDouble(a));
		return return_value;
	}
	
}
