package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.event.player.IPlayerDamageEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;

public class LightningStrikesTwice extends AchievementDefinition implements IPlayerDamageEvent
{

	public LightningStrikesTwice(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 18;

	@Override
	public void OnPlayerDamage(IPlayer player, RunsafeEntityDamageEvent event)
	{
		if (player.isInUniverse("survival") && event.getCause() == RunsafeEntityDamageEvent.RunsafeDamageCause.LIGHTNING)
			if (this.achievementHandler.hasAchievement(player, WhatAreTheOdds.ID))
				this.award(player, ID);
	}
}
