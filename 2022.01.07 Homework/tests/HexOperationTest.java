package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.HexDigit;

public class HexOperationTest
{
	public static void test(AbstractCalculator calculator)
	{
		Digit a=new HexDigit("1A47B");
		Digit b=new HexDigit("67");

		Digit addResult=calculator.add(a, b);
		System.out.println("+ Addition Result +");
		calculator.nativeRender(addResult);
		calculator.binaryRender(addResult);

		Digit subResult=calculator.sub(a, b);
		System.out.println("\n"+"- Subtraction Result -");
		calculator.nativeRender(subResult);
		calculator.octRender   (subResult);

		Digit mulResult=calculator.mul(a, b);
		System.out.println("\n"+"* Multiplication Result *");
		calculator.nativeRender (mulResult);
		calculator.decimalRender(mulResult);

		Digit divResult=calculator.div(a, b);
		System.out.println("\n"+"/ Division Result /");
		calculator.nativeRender(divResult);
		calculator.hexRender   (divResult);
	}
}
