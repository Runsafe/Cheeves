package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.projectiles.IProjectile;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;

public class Bullseye extends AchievementDefinition implements IEntityDamageByEntityEvent
{
	public Bullseye(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 42;

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
			award(shooter, ID);
	}
}
