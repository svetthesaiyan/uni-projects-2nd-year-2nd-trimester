package digits;

import calculators.Digit;

public class BinaryDigit extends Digit
{
	public BinaryDigit(String nativeValue) {super(nativeValue , BINARY);}
	public BinaryDigit(int   decimalValue) {super(decimalValue, BINARY);}
	
	public String renderNative()
	{
		return (this.hasNativeValue()) 
				? this.getNativeValue()
						: this.renderBinary();
	}
}
