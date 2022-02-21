package util;

import models.Car;
import models.ElectronicCar;
import models.GasCar;
import models.HybridCar;

public class Parser
{
	public static Car getCarFromString(String input)
	{
		String[] parts=input.split(", ");
		String keyWord=(parts[0].split(" "))[0];
		Car car=null;
		
//		if(input.startsWith("GAS_CAR"))
//		{
//			...
//		}
		switch(keyWord)
		{
			case "ELECTRIC_CAR" -> car=parseElectronicCar(parts);
			case "GAS_CAR" 		-> car=parseGasCar		 (parts);
			case "HYBRID_CAR" 	-> car=parseHybridCar	 (parts);
		}

		return car;
	}

	private static ElectronicCar parseElectronicCar(String[] parts)	{return null;}
	private static GasCar 		 parseGasCar	   (String[] parts) {return null;}
	private static HybridCar 	 parseHybridCar    (String[] parts) {return null;}
}
