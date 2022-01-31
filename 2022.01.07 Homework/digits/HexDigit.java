package digits;

import calculators.Digit;

public class HexDigit extends Digit
{
	public HexDigit(int   decimalValue) {super(decimalValue, HEX);}
	public HexDigit(String nativeValue)	{super(nativeValue , HEX);}
	
	public String renderNative()
	{
		return (this.hasNativeValue())
				? this.getNativeValue()
						: this.renderHex();
	}
}
