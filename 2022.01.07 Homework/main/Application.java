package main;

import processor.MathCalculator;
import tests.BinaryOperationsTest;
import tests.DecimalOperationTest;
import tests.HexOperationTest;
import tests.MixOperationTest;
import tests.MultiOperationTest;
import tests.OctOperationTest;

public class Application
{
	public static void main(String[] args)
	{
		MathCalculator calculator=new MathCalculator();

		System.out.println("1. Binary Operations");
		BinaryOperationsTest.test(calculator);
		System.out.println("\n"+"- - - - - - - - - - - - - -"+"\n"+"\n"+"2. Octal Operations");
		OctOperationTest 	.test(calculator);
		System.out.println("\n"+"- - - - - - - - - - - - - -"+"\n"+"\n"+"3. Decimal Operations");
		DecimalOperationTest.test(calculator);
		System.out.println("\n"+"- - - - - - - - - - - - - -"+"\n"+"\n"+"4. Hexal Operations");
		HexOperationTest	.test(calculator);
		
//		System.out.println("\n"+"- - - - - - - - - - - - - -"+"\n"+"\n"+"5. Mixed Operations");
//		MixOperationTest  .test(calculator);
		System.out.println("\n"+"- - - - - - - - - - - - - -"+"\n"+"\n"+"6. Multiple Operations");
		MultiOperationTest.test(calculator);
	}
}
