package calculators;

public abstract class AbstractCalculator 
{
    public abstract Digit add(Digit a, Digit b);
    public abstract Digit sub(Digit a, Digit b);
    public abstract Digit mul(Digit a, Digit b);
    public abstract Digit div(Digit a, Digit b);
    
    public abstract Digit addMulti(Digit ...collection);
    public abstract Digit subMulti(Digit ...collection);
    public abstract Digit mulMulti(Digit ...collection);
    public abstract Digit divMulti(Digit ...collection);
    
	public void renderNative (Digit a) {System.out.println("Native: " +a.renderNative());}
	public void renderBinary (Digit a) {System.out.println("Binary:"  +a.renderBinary());}
	public void renderOct	 (Digit a) {System.out.println("Octal:"	  +a.renderOct());}
	public void renderDecimal(Digit a) {System.out.println("Decimal: "+a.renderDecimal());}
	public void renderHex	 (Digit a) {System.out.println("Hexal: "  +a.renderHex());}
	
	public void nativeRender (Digit a) {this.renderNative (a);}
	public void binaryRender (Digit a) {this.renderBinary (a);}
	public void octRender	 (Digit a) {this.renderOct	  (a);}
	public void decimalRender(Digit a) {this.renderDecimal(a);}	
	public void hexRender	 (Digit a) {this.renderHex	  (a);}		
}
