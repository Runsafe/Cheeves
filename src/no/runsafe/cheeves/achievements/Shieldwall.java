package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

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
		this.sprees.remove(event.getEntity().getName());
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		if (event.getEntity() instanceof RunsafePlayer)
		{
			RunsafePlayer player = (RunsafePlayer) event.getEntity();

			if (!this.achievementHandler.hasAchievement(player, this))
			{
				RunsafeEntityType entityType = event.getDamageActor().getEntityType();

				if (Shieldwall.requiredMobs.contains(entityType))
				{
					this.registerKill(player, entityType);
				}
				else if (entityType instanceof ProjectileEntity)
				{
					RunsafeEntityType shooter = ((RunsafeProjectile) event.getDamageActor()).getShooter().getEntityType();
					if (Shieldwall.requiredMobs.contains(shooter))
						this.registerKill(player, shooter);
				}
			}
		}
	}

	private void registerKill(RunsafePlayer player, RunsafeEntityType type)
	{
		String playerName = player.getName();
		if (!this.sprees.containsKey(playerName))
			this.sprees.put(playerName, new ArrayList<RunsafeEntityType>());

		if (!this.sprees.get(playerName).contains(type))
		{
			this.sprees.get(playerName).add(type);
			this.checkProgress(player);
		}
	}

	private void checkProgress(RunsafePlayer player)
	{
		for (RunsafeEntityType type : Shieldwall.requiredMobs)
			if (!this.sprees.get(player.getName()).contains(type))
				return;

		this.award(player);
	}

	private HashMap<String, List<RunsafeEntityType>> sprees = new HashMap<String, List<RunsafeEntityType>>();
	private static List<RunsafeEntityType> requiredMobs = new ArrayList<RunsafeEntityType>();

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
