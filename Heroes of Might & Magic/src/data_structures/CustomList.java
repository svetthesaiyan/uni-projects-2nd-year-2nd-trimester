package data_structures;

public interface CustomList<T>
{
	// всички методи при `interface`-ите са `public` и `abstract` по шаблон
	T get(int index);
	
	void removeAt(int index);
	void add(T element);
}
