package entitites;

import abstract_entities.Unit;
import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public class UnitWarrior extends Unit
{
	public UnitWarrior()
	{
		super(UnitClassEnum.HUNTER, AttackTypeEnum.SLASH, 15, 15, 20, 1, 1, false);
	}
}
