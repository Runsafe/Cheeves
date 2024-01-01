package no.runsafe.cheeves;

import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.plugin.IPluginEnabled;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AchievementHandler implements IPluginEnabled
{
	public AchievementHandler(AchievementRepository repository, IOutput server)
	{
		this.repository = repository;
		this.server = server;
	}

	@Override
	public void OnPluginEnabled()
	{
		this.earnedAchievements = repository.getAchievements();
	}

	public void awardAchievement(Achievement achievement, IPlayer player)
	{
		this.awardAchievement(achievement, player, false);
	}

	public void awardAchievement(Achievement achievement, IPlayer player, boolean serverFirst)
	{
		if (serverFirst && this.hasHadServerFirst(achievement.getAchievementID()))
			return;

		if (this.hasAchievement(player, achievement))
			return;

		boolean toasted = false;
		if (player.isOnline())
		{
			player.playSound(Sound.UI.ChallengeComplete);
			this.announceAchievement(achievement, player);
			toasted = true;
		}

		if (!this.earnedAchievements.containsKey(player))
			this.earnedAchievements.put(player, new ArrayList<>());

		this.earnedAchievements.get(player).add(achievement.getAchievementID());
		this.repository.storeAchievement(player, achievement, toasted);
	}

	public void announceAchievement(Achievement achievement, IPlayer player)
	{
		server.broadcastComplex(
			String.format(Config.Message.getAnnounce(), player.getPrettyName(), achievement.getAchievementName()),
			String.format(Config.Message.getInfoColour(), achievement.getAchievementInfo()), null
		);
	}

	public List<Integer> getPlayerAchievements(IPlayer player)
	{
		return (this.earnedAchievements.getOrDefault(player, null));
	}

	public boolean hasAchievement(IPlayer player, Achievement achievement)
	{
		return this.hasAchievement(player, achievement.getAchievementID());
	}

	public boolean hasAchievement(IPlayer player, int achievementID)
	{
		return this.earnedAchievements.containsKey(player) && this.earnedAchievements.get(player).contains(achievementID);
	}

	public HashMap<IPlayer, List<Integer>> getEarnedAchievements()
	{
		return this.earnedAchievements;
	}

	public void registerServerFirst(int achievementID)
	{
		this.serverFirstAchievements.add(achievementID);
	}

	private boolean hasHadServerFirst(int achievementID)
	{
		return this.serverFirstAchievements.contains(achievementID);
	}

	private HashMap<IPlayer, List<Integer>> earnedAchievements = new HashMap<>();
	private final List<Integer> serverFirstAchievements = new ArrayList<>();
	private final AchievementRepository repository;
	private final IOutput server;
}
