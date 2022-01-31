package digits;

import calculators.Digit;

public class OctDigit extends Digit
{
	public OctDigit(int   decimalValue) {super(decimalValue, OCTAL);}
	public OctDigit(String nativeValue)	{super(nativeValue , OCTAL);}
	
	public String renderNative()
	{
		return (this.hasNativeValue())
				? this.getNativeValue()
						: this.renderOct();
	}
}
