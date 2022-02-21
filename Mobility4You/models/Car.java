package models;

public abstract class Car 
{
	// общи променливи за всички коли
	protected String brand;
	protected String model;
	protected int enginePower;
	protected int price;
	
	// конструктор с общите променливи
	public Car(String brand, String model, int enginePower, int price)
	{
		this.brand		=brand;
		this.model		=model;
		this.enginePower=enginePower;
		this.price		=price;
	}
	
	public String toString(String middlePart) 
	{
		StringBuilder builder=new StringBuilder();
		builder.append(this.brand);
		builder.append(", ");
		builder.append(this.model);
		builder.append(", ");
		builder.append(middlePart);
		builder.append(", ");
		builder.append(this.price);
		builder.append(" euro");
		
		return builder.toString();
	}
}
