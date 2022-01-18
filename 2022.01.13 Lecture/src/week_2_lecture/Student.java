package week_2_lecture;

public class Student extends Human
{
	String facultyNumber;
	
	public Student(int age, String name, char gender, String facultyNumber)
	{
		super(age, name, gender);
		this.facultyNumber=facultyNumber;
	}
	
//	public void print()
//	{
//		super.print();
//		System.out.println(", "+this.facNumber);
//	}
	
	public String toString()
	{
		return super.toString()+", "+this.facultyNumber;
	}
}
