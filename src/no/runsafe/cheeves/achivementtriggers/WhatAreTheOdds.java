package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.player.IPlayerDamageEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class WhatAreTheOdds extends AchievementDefinition implements IPlayerDamageEvent
{
	public WhatAreTheOdds(AchievementDefinitionRepository repository, AchievementHandler achievementHandler, IScheduler scheduler)
	{
		super(repository, achievementHandler);
		this.scheduler = scheduler;
	}

	public static final int ID = 16;

	@Override
	public void OnPlayerDamage(final IPlayer player, RunsafeEntityDamageEvent event)
	{
		if (!player.isInUniverse("survival") || event.getCause() != RunsafeEntityDamageEvent.RunsafeDamageCause.LIGHTNING)
			return;

		if (this.awardedPlayers.contains(player))
			return;

		this.awardedPlayers.add(player);
		this.scheduler.startAsyncTask(() ->
		{
			award(player, ID);
			awardedPlayers.remove(player);
		}, 4);
	}

	private final List<IPlayer> awardedPlayers = new ArrayList<>();
	private final IScheduler scheduler;
}
