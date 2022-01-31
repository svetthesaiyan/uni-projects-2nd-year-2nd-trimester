package trimester_2_lectures;

public abstract class Human implements Comparable<Human>
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
	
	public int compareTo(Human h)
	{
		// return this.name.compareTo(h.name);
		
		if(this.age>h.age)
			return 1;
		if(this.age<h.age)
			return -1;
		
		return 0;
	}
	
	public abstract void whoAmI();
	
	public void print() {System.out.print("\n"+this.age+", "+this.name+", "+this.gender);}
	public String toString() {return 		   this.age+", "+this.name+", "+this.gender;}
	
	public abstract int plus(int a, int b);
}
