package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.projectiles.IProjectile;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;

public class Bullseye extends Achievement implements IEntityDamageByEntityEvent
{
	public Bullseye(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Bullseye";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Shoot a player with an arrow from over 40 blocks away.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.BULLSEYE.ordinal();
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		IEntity entity = event.getEntity();
		if (!(entity instanceof IPlayer))
			return;

		IEntity attacker = event.getDamageActor();
		if (attacker.getEntityType() != ProjectileEntity.Arrow)
			return;

		IPlayer shooter = ((IProjectile) attacker).getShootingPlayer();
		if (shooter == null)
			return;
		ILocation playerLocation = entity.getLocation();
		ILocation shooterLocation = shooter.getLocation();

		if (playerLocation != null && shooterLocation != null && playerLocation.distance(shooterLocation) >= 40)
			award(shooter);
	}
}
