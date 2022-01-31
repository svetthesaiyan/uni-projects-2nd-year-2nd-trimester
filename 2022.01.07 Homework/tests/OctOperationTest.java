package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.DecimalDigit;
import digits.OctDigit;

public class OctOperationTest
{
	public static void test(AbstractCalculator calculator)
	{
		Digit a=new OctDigit("531");
		Digit b=new OctDigit("67");

		Digit addResult=calculator.add(a, b);
		System.out.println("+ Addition result +");
		calculator.nativeRender(addResult);
		calculator.binaryRender(addResult);

		Digit subResult=calculator.sub(a, b);
		System.out.println("\n"+"- Subtraction result -");
		calculator.nativeRender(subResult);
		calculator.octRender   (subResult);

		Digit mulResult=calculator.mul(a, b);
		System.out.println("\n"+"* Multiplication result *");
		calculator.nativeRender (mulResult);
		calculator.decimalRender(mulResult);

		Digit divResult=calculator.div(a, b);
		System.out.println("\n"+"/ Division result /");
		calculator.nativeRender(divResult);
		calculator.hexRender   (divResult);
	}
}
