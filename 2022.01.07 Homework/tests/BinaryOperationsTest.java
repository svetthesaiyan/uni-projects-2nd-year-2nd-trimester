package tests;

import calculators.AbstractCalculator;
import digits.BinaryDigit;

public class BinaryOperationsTest
{
	public static void test(AbstractCalculator calculator)
	{
		BinaryDigit a=new BinaryDigit("1101");
		BinaryDigit b=new BinaryDigit("0011");

		BinaryDigit addResult=(BinaryDigit)calculator.add(a, b);
		System.out.println("+ Addition Result +");
		calculator.renderNative (addResult);
		calculator.renderDecimal(addResult);

		BinaryDigit subResult=(BinaryDigit)calculator.sub(a, b);
		System.out.println("\n"+"- Subtraction Result -");
		calculator.renderNative (subResult);
		calculator.renderDecimal(subResult);

		BinaryDigit mulResult=(BinaryDigit)calculator.mul(a, b);
		System.out.println("\n"+"* Multiplication Result *");
		calculator.renderNative (mulResult);
		calculator.renderDecimal(mulResult);

		BinaryDigit divResult=(BinaryDigit)calculator.div(a, b);
		System.out.println("\n"+"/ Division Result /");
		calculator.renderNative (divResult);
		calculator.renderDecimal(divResult);
	}
}