package calculators;

public abstract class Digit
{
	public static final int BINARY =2;
	public static final int OCTAL  =8;
	public static final int DECIMAL=10;
	public static final int HEX    =16;
	
	protected String nativeValue;
	protected int decimalValue;
	protected int radix;
	
	public Digit(String nativeValue, int radix)
	{
		this.nativeValue=nativeValue;
		this.radix=radix;
		this.decimalValue=Integer.parseInt(nativeValue, radix);
	}
	
	public Digit(int decimalValue, int radix)
	{
		this.nativeValue=null;
		this.radix=radix;
		this.decimalValue=decimalValue;
	}
	
	public abstract String renderNative();
	
	public boolean hasNativeValue()	{return this.getNativeValue()!=null;}
	public String getNativeValue () {return this.nativeValue;}
	
	public int getDecimal()	{return this.decimalValue;}
	
	public String renderBinary () {return Integer.toBinaryString(this.decimalValue);}
	public String renderOct	   () {return Integer.toOctalString (this.decimalValue);}
	public String renderDecimal() {return String.valueOf			 (decimalValue);}
	public String renderHex	   () {return Integer.toHexString	(this.decimalValue);}
	
	public boolean isBinary () {return this.radix==BINARY;}
	public boolean isOct    () {return this.radix==OCTAL;}
	public boolean isDecimal() {return this.radix==DECIMAL;}
	public boolean isHex	() {return this.radix==HEX;}
}
