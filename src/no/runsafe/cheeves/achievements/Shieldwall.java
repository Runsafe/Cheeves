package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.player.IPlayerDeathEvent;
import no.runsafe.framework.server.entity.LivingEntity;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.entity.RunsafeEntityType;
import no.runsafe.framework.server.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerDeathEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

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
		return "Take damage from the following mobs without dying: ";
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
			RunsafeEntityType entityType = event.getDamageActor().getEntityType();

			if (Shieldwall.requiredMobs.contains(entityType))
				this.registerKill((RunsafePlayer) event.getEntity(), entityType);
		}
	}

	private void registerKill(RunsafePlayer player, RunsafeEntityType type)
	{
		String playerName = player.getName();
		if (!this.sprees.containsKey(playerName))
			this.sprees.put(playerName, new ArrayList<RunsafeEntityType>());

		if (!this.sprees.get(playerName).contains(type))
			this.sprees.get(playerName).add(type);
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
