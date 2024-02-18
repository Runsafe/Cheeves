package no.runsafe.cheeves.listeners;

import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.player.IPlayerJoinEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerJoinEvent;

import java.util.List;

public class AchievementChecker implements IPlayerJoinEvent
{
	public AchievementChecker(AchievementHandler handler, AchievementDefinitionRepository definitionRepository, AchievementRepository repository, IScheduler scheduler)
	{
		this.handler = handler;
		this.definitionRepository = definitionRepository;
		this.repository = repository;
		this.scheduler = scheduler;
	}

	@Override
	public void OnPlayerJoinEvent(RunsafePlayerJoinEvent event)
	{
		final IPlayer player = event.getPlayer();
		final List<Integer> achievements = this.repository.getNonToastedAchievements(player);

		this.scheduler.startAsyncTask(() ->
		{
			for (Integer achievementID : achievements)
			{
				player.playSound(Sound.UI.ChallengeComplete);
				handler.announceAchievement(definitionRepository.getAchievementByID(achievementID), player);
			}
		}, 2);

		this.repository.clearNonToastedAchievements(player);
	}

	private final AchievementHandler handler;
	private final AchievementRepository repository;
	private final AchievementDefinitionRepository definitionRepository;
	private final IScheduler scheduler;
}
