package no.runsafe.cheeves;

import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.api.event.plugin.IPluginEnabled;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AchievementHandler implements IPluginEnabled
{
	public AchievementHandler(AchievementRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public void OnPluginEnabled()
	{
		this.earnedAchievements = repository.getAchievements();
	}

	public void awardAchievement(Achievement achievement, RunsafePlayer player)
	{
		if (!this.hasAchievement(player, achievement))
		{
			boolean toasted = false;
			if (player.isOnline())
			{
				this.announceAchievement(achievement, player);
				toasted = true;
			}

			String playerName = player.getName();
			if (!this.earnedAchievements.containsKey(playerName))
				this.earnedAchievements.put(playerName, new ArrayList<Integer>());

			this.earnedAchievements.get(playerName).add(achievement.getAchievementID());
			this.repository.storeAchievement(playerName, achievement, toasted);
		}
	}

	public void announceAchievement(Achievement achievement, RunsafePlayer player)
	{
		RunsafeServer.Instance.broadcastMessage(String.format(
				"%s &ehas earned the achievement &3%s&e.",
				player.getPrettyName(),
				achievement.getAchievementName()
		));
	}

	public List<Integer> getPlayerAchievements(RunsafePlayer player)
	{
		String playerName = player.getName();
		return (this.earnedAchievements.containsKey(playerName) ? this.earnedAchievements.get(playerName) : null);
	}

	public boolean hasAchievement(RunsafePlayer player, Achievement achievement)
	{
		return this.hasAchievement(player, achievement.getAchievementID());
	}

	public boolean hasAchievement(RunsafePlayer player, int achievementID)
	{
		String playerName = player.getName().toLowerCase();
		return this.earnedAchievements.containsKey(playerName) && this.earnedAchievements.get(playerName).contains(achievementID);
	}

	private HashMap<String, List<Integer>> earnedAchievements = new HashMap<String, List<Integer>>();
	private AchievementRepository repository;
}
