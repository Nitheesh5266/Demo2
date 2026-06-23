package TestNg;
 
import org.testng.annotations.Test;
 
public class MathDemo {
 
	@Test //test case
	public void sumTC()
	{
		//logic
		add(20,40);
		//multiplication(10,50);
	}
 
	@Test //test case
	public void multiplicationTC()
	{
		//logic		
		multiplication(20,50);
	}
 
	//user defined method for addition
	public static void add(int num1,int num2)
	{
		int sum=num1+num2;
		System.out.println("Sum of "+num1+" & "+num2+" is: "+sum);
	}
 
	//user defined method for multiplication
	public static void multiplication(int num1,int num2)
	{
		int result=num1*num2;
		System.out.println("Multiplication of "+num1+" & "+num2+" is: "+result);
	}
 
}