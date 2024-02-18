package no.runsafe.cheeves.listeners;

import no.runsafe.cheeves.AchievementEarnedEvent;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.cheeves.database.ConfiguredAchievement;
import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

import java.util.HashMap;

public class ConfiguredAchievementTracker implements IPlayerCustomEvent, IConfigurationChanged
{
	public ConfiguredAchievementTracker(AchievementHandler handler, AchievementDefinitionRepository repository)
	{
		this.repository = repository;
		this.achievementHandler = handler;
		this.achievements = new HashMap<>();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		IAchievement achievement = event instanceof AchievementEarnedEvent
				? ((AchievementEarnedEvent) event).getAchievement()
				: achievements.get(event.getEvent());

		if (achievement != null)
		{
			achievementHandler.awardAchievement(achievement, event.getPlayer());
		}
	}

	@Override
	public void OnConfigurationChanged(IConfiguration configuration)
	{
		achievements.clear();
		for (ConfiguredAchievement achievement : repository.getAchievements())
		{
			achievements.put(achievement.getTriggerEvent(), achievement);
		}
	}

	private final AchievementHandler achievementHandler;
	private final AchievementDefinitionRepository repository;
	private final HashMap<String, ConfiguredAchievement> achievements;
}
