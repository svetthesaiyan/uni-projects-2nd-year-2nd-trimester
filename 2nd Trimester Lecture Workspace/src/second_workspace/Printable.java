package second_workspace;

@FunctionalInterface
public interface Printable<T>
{
	final int TEST=3;
	
	void printSomething(T text, T moreText);
	
	static  void saySomething() {System.out.println("I am here.");}
	default void 	   method() {System.out.println("");}
}
