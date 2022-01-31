package digits;

import calculators.Digit;

public class DecimalDigit extends Digit
{
	public DecimalDigit(String value) {super(value, DECIMAL);}
	public DecimalDigit(int    value) {super(value, DECIMAL);}
	
	public String renderNative()
	{
		return (this.hasNativeValue()) 
				? this.getNativeValue()
						: this.renderDecimal();
	}
}
