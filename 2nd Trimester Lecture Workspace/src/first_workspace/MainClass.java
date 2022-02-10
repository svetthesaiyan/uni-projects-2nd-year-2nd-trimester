package first_workspace;

import java.util.ArrayList;
import java.util.Comparator;

public class MainClass
{
	public static void main(String[] args)
	{
		Student  s=new Student (20, "Svetoslav", 'M', "2001261051");	// 3 конструктора
		Lecturer l=new Lecturer(38, "Vlado"    , 'M', 1500.49f);
		
		ArrayList<Human> list=new ArrayList<>();
		list.add(s);
		list.add(0, l);
		list.add(s);
		list.add(l);	

		System.out.println("Before sort:"+"\n");
		for(Human h:list) {System.out.println(h);}
		
		Comparator<Human> byAge=(Human o1, Human o2) -> Integer.compare(o1.age, o2.age);
		list.sort(byAge);
		
		System.out.println("\n"+"After sort:"+"\n");
		for(Human h:list) {System.out.println(h);}
	}
}
