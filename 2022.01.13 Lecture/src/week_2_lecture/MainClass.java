package week_2_lecture;

public class MainClass
{
	public static void main(String[] args)
	{
		Human h=new Human(21, "Georgi", 'M');
		System.out.println(h);
//		h.print();
		
		Student s=new Student(20, "Svetoslav", 'M', "2001261051");
		System.out.println(s);
//		s.print();
	}
}
