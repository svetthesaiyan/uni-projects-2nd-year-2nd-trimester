package abstract_entities;

import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public abstract class Unit
{
	protected UnitClassEnum unitClass;
	protected AttackTypeEnum attackType;
	
	protected int health;
	protected int attack;
	protected int defence;
	
	protected int rangeIndex;
	protected int moveIndex;
	
	protected boolean canFly;
	
	public Unit(UnitClassEnum unitClass, AttackTypeEnum attackType, int health, int attack, int defence, int rangeIndex, int moveIndex, boolean canFly)
	{
		this.unitClass=unitClass;
		this.attackType=attackType;
		this.health=health;
		this.attack=attack;
		this.defence=defence;
		this.rangeIndex=rangeIndex;
		this.moveIndex=moveIndex;
		this.canFly=canFly;
	}
}
