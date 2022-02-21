package models;

public class ElectronicCar extends Car
{
	protected int batteryCapacity;	// специфична променлива за `ElectronicCar`

	public ElectronicCar(String brand, String model, int enginePower, int batteryCapacity, int price) 
	{
		super(brand, model, enginePower, price);	// това е задължително първият ред на конструктора
		this.batteryCapacity=batteryCapacity;
	}
	
	public String toString() 
	{
		String middle=this.enginePower+"KW, " + this.batteryCapacity+"Ah";
		return "ELECTRIC_CAR " + super.toString(middle);
	}
}
