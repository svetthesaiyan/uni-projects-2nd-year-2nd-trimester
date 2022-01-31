package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.BinaryDigit;
import digits.DecimalDigit;

public class MixOperationTest
{
	public static void test(AbstractCalculator calculator)
	{
		Digit a=new BinaryDigit("1101");
		Digit b=new DecimalDigit("10574");
		
		BinaryDigit addResult=(BinaryDigit)calculator.add(a, b);
		System.out.println("+ Addition Result +");
		calculator.renderNative (addResult);
		calculator.renderDecimal(addResult);

		DecimalDigit subResult=(DecimalDigit)calculator.sub(a, b);
		System.out.println("\n"+"- Subtraction Result -");
		calculator.renderNative(subResult);
		calculator.renderBinary(subResult);

		BinaryDigit mulResult=(BinaryDigit)calculator.mul(a, b);
		System.out.println("\n"+"* Multiplication Result *");
		calculator.renderNative(mulResult);
		calculator.renderOct   (mulResult);

		DecimalDigit divResult=(DecimalDigit)calculator.div(a, b);
		System.out.println("\n"+"/ Division Result /");
		calculator.renderNative(divResult);
		calculator.renderHex   (divResult);
	}
}
