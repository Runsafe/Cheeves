package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.player.IPlayerDamageEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class WhatAreTheOdds extends Achievement implements IPlayerDamageEvent
{
	public WhatAreTheOdds(AchievementHandler achievementHandler, IScheduler scheduler)
	{
		super(achievementHandler);
		this.scheduler = scheduler;
	}

	@Override
	public String getAchievementName()
	{
		return "What are the odds?";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Get struck by lightning in survival.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WHAT_ARE_THE_ODDS.ordinal();
	}

	@Override
	public void OnPlayerDamage(final RunsafePlayer player, RunsafeEntityDamageEvent event)
	{
		if (player.isInUniverse("survival") && event.getCause() == RunsafeEntityDamageEvent.RunsafeDamageCause.LIGHTNING)
			this.scheduler.startAsyncTask(new Runnable() {
				@Override
				public void run() {
					award(player);
				}
			}, 1);
	}

	private IScheduler scheduler;
}
