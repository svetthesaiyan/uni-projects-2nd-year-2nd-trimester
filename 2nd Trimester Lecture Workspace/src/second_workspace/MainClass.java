package second_workspace;

import java.util.Comparator;

public class MainClass
{
	public static void main(String[] args)
	{
		Printable lambda=(text, moreText) -> System.out.println("Print me here"+text+moreText);
		
		Comparator<ChildClass> byName=(ChildClass one, ChildClass two) -> one.name.compareTo(two.name);
		
		print(lambda);	
		Printable.saySomething();
	}
	
	public static void print(Printable print) {print.printSomething("... ", "thanks...");}
}
