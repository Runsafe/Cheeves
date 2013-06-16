package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class Gladiator extends Achievement implements IPlayerCustomEvent
{
	public Gladiator(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Gladiator";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a rating of 2000 in the PvP arena.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.GLADIATOR.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafePlayer player, String event, Object data)
	{
		if (event.equals("peeveepee.rating.change") && (Integer) data == 2000)
				this.award(player);
	}
}
