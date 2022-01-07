package entitites;

import abstract_entities.Unit;
import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public class UnitMage extends Unit
{
	public UnitMage()
	{
		super(UnitClassEnum.MAGE, AttackTypeEnum.MAGIC, 5, 5, 15, 7, 3, true);
	}
}
