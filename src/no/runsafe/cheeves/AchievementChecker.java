package no.runsafe.cheeves;

import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.api.event.player.IPlayerJoinEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerJoinEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public class AchievementChecker implements IPlayerJoinEvent
{
	public AchievementChecker(AchievementHandler handler, AchievementFinder finder, AchievementRepository repository)
	{
		this.handler = handler;
		this.finder = finder;
		this.repository = repository;
	}

	@Override
	public void OnPlayerJoinEvent(RunsafePlayerJoinEvent event)
	{
		RunsafePlayer player = event.getPlayer();
		List<Integer> achievements = this.repository.getNonToastedAchievements(player);

		for (Integer achievementID : achievements)
			this.handler.announceAchievement(this.finder.getAchievementByID(achievementID), player);

		this.repository.clearNonToastedAchievements(player);
	}

	private AchievementHandler handler;
	private AchievementFinder finder;
	private AchievementRepository repository;
}
