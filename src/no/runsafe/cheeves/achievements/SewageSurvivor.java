package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.player.IPlayer;

import java.util.HashMap;

public class SewageSurvivor extends Achievement
{
	public SewageSurvivor(AchievementHandler achievementHandler, IScheduler scheduler)
	{
		super(achievementHandler);
		this.scheduler = scheduler;
	}

	@Override
	public String getAchievementName()
	{
		return "Sewage Survivor";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Survive in the sewers for five minutes without invisibility potions.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SEWAGE_SURVIVOR.ordinal();
	}

	private void startTimer(final IPlayer player)
	{
		String playerName = player.getName();
		if (!this.activeTimers.containsKey(playerName))
			this.activeTimers.put(playerName, this.scheduler.startAsyncTask(new Runnable() {
				@Override
				public void run()
				{
					award(player);
				}
			}, 300));
	}

	private void stopTimer(IPlayer player)
	{
		String playerName = player.getName();
		if (this.activeTimers.containsKey(playerName))
			this.scheduler.cancelTask(this.activeTimers.get(playerName));
	}

	private final HashMap<String, Integer> activeTimers = new HashMap<String, Integer>();
	private final IScheduler scheduler;
}
