package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.DecimalDigit;

public class DecimalOperationTest
{
	public static void test(AbstractCalculator calculator)
	{
		Digit a=new DecimalDigit("105");
		Digit b=new DecimalDigit("240");

		Digit addResult=calculator.add(a, b);
		System.out.println("+ Addition result +");
		calculator.renderNative(addResult);
		calculator.renderHex   (addResult);

		Digit subResult=calculator.sub(a, b);
		System.out.println("\n"+"- Subtraction result -");
		calculator.renderNative(subResult);
		calculator.renderHex   (subResult);

		Digit mulResult=calculator.mul(a, b);
		System.out.println("\n"+"* Multiplication result *");
		calculator.renderNative(mulResult);
		calculator.renderHex   (mulResult);

		Digit divResult=calculator.div(a, b);
		System.out.println("\n"+"/ Division result /");
		calculator.renderNative(divResult);
		calculator.renderHex   (divResult);
	}
}
