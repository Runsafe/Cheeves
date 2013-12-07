package no.runsafe.cheeves;

import no.runsafe.framework.api.player.IPlayer;

public abstract class ServerFirstAchievement extends Achievement
{
	public ServerFirstAchievement(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public void award(IPlayer player)
	{
		this.achievementHandler.awardAchievement(this, player, true);
		this.achievementHandler.registerServerFirst(this.getAchievementID());
	}
}
