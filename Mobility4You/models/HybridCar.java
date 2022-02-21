package models;

public class HybridCar extends Car
{
	// специфични променливи за `HybridCar`
	protected int 	batteryCapacity;
	protected float engineDisplacement;

	public HybridCar(String brand, String model, float engineDisplacement, int enginePower, int batteryCapacity, int price)
	{
		super(brand, model, enginePower, price);
		this.engineDisplacement=engineDisplacement;
		this.batteryCapacity   =batteryCapacity;
	}

	public String toString()
	{
		String middle=this.engineDisplacement+"L, " + this.enginePower+"KW, " + this.batteryCapacity+"Ah";
		return "HYBRID_CAR " + super.toString(middle);
	}
}
