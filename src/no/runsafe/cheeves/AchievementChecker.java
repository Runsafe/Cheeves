package no.runsafe.cheeves;

import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.player.IPlayerJoinEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerJoinEvent;

import java.util.List;

public class AchievementChecker implements IPlayerJoinEvent
{
	public AchievementChecker(AchievementHandler handler, AchievementFinder finder, AchievementRepository repository, IScheduler scheduler)
	{
		this.handler = handler;
		this.finder = finder;
		this.repository = repository;
		this.scheduler = scheduler;
	}

	@Override
	public void OnPlayerJoinEvent(RunsafePlayerJoinEvent event)
	{
		final IPlayer player = event.getPlayer();
		final List<Integer> achievements = this.repository.getNonToastedAchievements(player);

		this.scheduler.startAsyncTask(new Runnable() {
			@Override
			public void run()
			{
				for (Integer achievementID : achievements)
					handler.announceAchievement(finder.getAchievementByID(achievementID), player);
			}
		}, 2);

		this.repository.clearNonToastedAchievements(player);
	}

	private AchievementHandler handler;
	private AchievementFinder finder;
	private AchievementRepository repository;
	private IScheduler scheduler;
}
