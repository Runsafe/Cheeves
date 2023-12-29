package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.entity.IProjectileSource;
import no.runsafe.framework.api.entity.projectiles.IProjectile;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shieldwall extends Achievement implements IEntityDamageByEntityEvent, IPlayerDeathEvent
{
	public Shieldwall(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Shield-wall";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Take damage from the following mobs without dying: Blaze, Cave Spider, Enderman, Creeper, Ghast, Lava Slime, Iron Golem, Zombie Pigman, Silverfish, Skeleton, Zombie, Witch, Wither, Wolf, Slime, Spider.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SHIELDWALL.ordinal();
	}

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		this.sprees.remove(event.getEntity());
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		if (!(event.getEntity() instanceof IPlayer))
			return;

		IPlayer player = (IPlayer) event.getEntity();
		if (this.achievementHandler.hasAchievement(player, this) || !player.isInUniverse("survival"))
			return;

		RunsafeEntityType entityType = event.getDamageActor().getEntityType();

		if (Shieldwall.requiredMobs.contains(entityType))
		{
			this.registerKill(player, entityType);
			return;
		}

		if (!(event.getDamageActor() instanceof IProjectile))
			return;

		IProjectileSource shooterSource = ((IProjectile) event.getDamageActor()).getShooter();
		if(!(shooterSource instanceof ILivingEntity))
			return;

		ILivingEntity shooter = (ILivingEntity) shooterSource;

		if (Shieldwall.requiredMobs.contains(shooter.getEntityType()))
			this.registerKill(player, shooter.getEntityType());
	}

	private void registerKill(IPlayer player, RunsafeEntityType type)
	{
		if (!this.sprees.containsKey(player))
			this.sprees.put(player, new ArrayList<>());

		if (!this.sprees.get(player).contains(type))
		{
			this.sprees.get(player).add(type);
			this.checkProgress(player);
		}
	}

	private void checkProgress(IPlayer player)
	{
		for (RunsafeEntityType type : Shieldwall.requiredMobs)
			if (!this.sprees.get(player).contains(type))
				return;

		this.award(player);
	}

	private final HashMap<IPlayer, List<RunsafeEntityType>> sprees = new HashMap<>();
	private static final List<RunsafeEntityType> requiredMobs = new ArrayList<>();

	static
	{
		requiredMobs.add(LivingEntity.Blaze);
		requiredMobs.add(LivingEntity.CaveSpider);
		requiredMobs.add(LivingEntity.Enderman);
		requiredMobs.add(LivingEntity.Creeper);
		requiredMobs.add(LivingEntity.Ghast);
		requiredMobs.add(LivingEntity.LavaSlime);
		requiredMobs.add(LivingEntity.IronGolem);
		requiredMobs.add(LivingEntity.PigZombie);
		requiredMobs.add(LivingEntity.Silverfish);
		requiredMobs.add(LivingEntity.Skeleton);
		requiredMobs.add(LivingEntity.Zombie);
		requiredMobs.add(LivingEntity.Witch);
		requiredMobs.add(LivingEntity.Wither);
		requiredMobs.add(LivingEntity.Wolf);
		requiredMobs.add(LivingEntity.Slime);
		requiredMobs.add(LivingEntity.Spider);
	}
}
