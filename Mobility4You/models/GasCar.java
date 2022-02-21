package models;

public class GasCar extends Car
{
	protected float engineDisplacement;	// специфична променлива за `GasCar`

	public GasCar(String brand, String model, float engineDisplacement, int enginePower, int price) 
	{
		super(brand, model, enginePower, price);
		this.engineDisplacement=engineDisplacement;
	}
	
	public String toString() 
	{
		String middle=this.engineDisplacement+"L, " + this.enginePower+"KW";
		return "GAS_CAR " + super.toString(middle);
	}
}
