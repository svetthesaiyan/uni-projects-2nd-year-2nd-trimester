package trimester_2_lectures;

public class Student extends Human
{
	String facultyNumber;
	
	public Student(int age, String name, char gender, String facultyNumber)
	{
		super(age, name, gender);
		this.facultyNumber=facultyNumber;
	}
	
	public void print()
	{
		super.print();
		System.out.println(", "+this.facultyNumber);
	}
	
	public String toString() {return super.toString()+", "+this.facultyNumber;}
	
	@Override
	public void whoAmI() {System.out.println("I am a student.");}
	
	@Override
	public int plus(int a, int b)
	{
		int result=a+b;
		return result;
	}
}
