package no.runsafe.cheeves;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public abstract class ServerFirstAchievement extends Achievement
{
	public ServerFirstAchievement(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public void award(RunsafePlayer player)
	{
		this.achievementHandler.awardAchievement(this, player, true);
	}
}
