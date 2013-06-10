package no.runsafe.cheeves;

import no.runsafe.cheeves.achievements.IAchievement;
import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.configuration.IConfiguration;
import no.runsafe.framework.event.IConfigurationChanged;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AchievementHandler implements IConfigurationChanged
{
	public AchievementHandler(AchievementRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public void OnConfigurationChanged(IConfiguration configuration)
	{
		this.earnedAchievements = repository.getAchievements();
	}

	public void awardAchievement(IAchievement achievement, RunsafePlayer player)
	{
		if (!this.hasAchievement(player, achievement))
		{
			RunsafeServer.Instance.broadcastMessage(String.format(
					"%s &ehas earned the achievement &3%s&e.",
					player.getPrettyName(),
					achievement.getAchievementName()
			));

			String playerName = player.getName();
			if (!this.earnedAchievements.containsKey(playerName))
				this.earnedAchievements.put(playerName, new ArrayList<Integer>());

			this.earnedAchievements.get(playerName).add(achievement.getAchievementID());
			this.repository.storeAchievement(playerName, achievement);
		}
	}

	public List<Integer> getPlayerAchievements(RunsafePlayer player)
	{
		String playerName = player.getName();
		return (this.earnedAchievements.containsKey(playerName) ? this.earnedAchievements.get(playerName) : null);
	}

	public boolean hasAchievement(RunsafePlayer player, IAchievement achievement)
	{
		String playerName = player.getName();
		return this.earnedAchievements.containsKey(playerName) && this.earnedAchievements.get(playerName).contains(achievement.getAchievementID());
	}

	private HashMap<String, List<Integer>> earnedAchievements = new HashMap<String, List<Integer>>();
	private AchievementRepository repository;
}
