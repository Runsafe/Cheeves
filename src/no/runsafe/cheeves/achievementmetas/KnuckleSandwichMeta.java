package no.runsafe.cheeves.achievementmetas;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;

public class KnuckleSandwichMeta
{
	public KnuckleSandwichMeta(RunsafeEntity entity)
	{
		this.entity = entity;
	}

	public int getDamage()
	{
		return this.damage;
	}

	public boolean isSameEntity(RunsafeEntity check)
	{
		return check.getEntityId() == this.entity.getEntityId();
	}

	public void setEntity(RunsafeEntity entity)
	{
		this.entity = entity;
	}

	public void resetDamage()
	{
		this.damage = 1;
	}

	public void addDamagePoint()
	{
		this.damage += 1;
	}

	private int damage;
	private RunsafeEntity entity;
}
