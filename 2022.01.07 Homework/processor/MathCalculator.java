package processor;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.BinaryDigit;
import digits.DecimalDigit;
import digits.HexDigit;
import digits.OctDigit;

public class MathCalculator extends AbstractCalculator
{
	public Digit add(Digit a, Digit b) // {return produceDigit(a, (a.getDecimal() + b.getDecimal()));}
	{
		int aDecimal=a.getDecimal();
		int bDecimal=b.getDecimal();
		int result=aDecimal+bDecimal;
		
		return produceDigit(a, result);
	}
	public Digit sub(Digit a, Digit b) {return produceDigit(a, (a.getDecimal() - b.getDecimal()));}
	public Digit mul(Digit a, Digit b) {return produceDigit(a, (a.getDecimal() * b.getDecimal()));}
	public Digit div(Digit a, Digit b) {return produceDigit(a, (a.getDecimal() / b.getDecimal()));}

	@Override
	public Digit addMulti(Digit ...collection) 
	{
		Digit operationMediator=collection[0];
		for(int i=1; i<collection.length; i++)
			operationMediator=this.add(operationMediator, collection[i]);
		
		return operationMediator;
	}

	@Override
	public Digit subMulti(Digit ...collection) 
	{
		Digit operationMediator=collection[0];
		for(int i=1; i<collection.length; i++)
			operationMediator=this.sub(operationMediator, collection[i]);
		
		return operationMediator;
	}

	@Override
	public Digit mulMulti(Digit ...collection) 
	{
		Digit operationMediator=collection[0];
		for(int i=1; i<collection.length; i++)
			operationMediator=this.mul(operationMediator, collection[i]);
		
		return operationMediator;
	}

	@Override
	public Digit divMulti(Digit ...collection) 
	{
		Digit operationMediator=collection[0];
		for(int i=1; i<collection.length; i++)
			operationMediator=this.div(operationMediator, collection[i]);
		
		return operationMediator;
	}
	
	private Digit produceDigit(Digit baseDigit, int value)
	{
		if(baseDigit.isBinary())
			return new BinaryDigit (value);
		if(baseDigit.isDecimal())
			return new DecimalDigit(value);
		if(baseDigit.isHex())
			return new HexDigit    (value);
		if(baseDigit.isOct())
			return new OctDigit    (value);
		
		return null;
	}
}
