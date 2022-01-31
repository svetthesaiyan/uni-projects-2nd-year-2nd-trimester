package trimester_2_lectures;

public class Lecturer extends Human
{
	float salary;
	
	public Lecturer(int age, String name, char gender, float salary)
	{
		super(age, name, gender);
		this.salary=salary;
	}
	
	public void print()
	{
		super.print();
		System.out.println(", "+this.salary);
	}
	
	public String toString() {return super.toString()+", "+this.salary;}
	
	@Override
	public void whoAmI() {System.out.println("I am a lecturer.");}

	@Override
	public int plus(int a, int b) {return 0;}
}
