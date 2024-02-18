package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.AchievementEarnedEvent;
import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.player.IPlayer;

public abstract class AchievementDefinition
{
	public AchievementDefinition(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		this.achievementHandler = achievementHandler;
		this.repository = repository;
	}

	public void award(IPlayer player, int id)
	{
		IAchievement achievement = repository.getAchievementByID(id);
		new AchievementEarnedEvent(achievement, player, achievement.getTriggerEvent()).Fire();
	}

	protected final AchievementHandler achievementHandler;
	protected final AchievementDefinitionRepository repository;
}

