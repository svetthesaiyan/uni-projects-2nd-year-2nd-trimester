package week_2_lecture;

public class Human
{
	int age;
	String name;
	char gender;
	
	public Human(int age, String name, char gender)
	{
		this.age   =age;
		this.name  =name;
		this.gender=gender;
	}
	
//	public void print()
//	{
//		System.out.print("\n"+this.age+", "+this.name+", "+this.gender);
//	}
	
	public String toString()
	{
		return this.age+", "+this.name+", "+this.gender;
	}
}
