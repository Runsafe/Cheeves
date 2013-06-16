package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class MercilessGladiator extends Achievement implements IPlayerCustomEvent
{
	public MercilessGladiator(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Merciless Gladiator";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a rating of 2500 in PvP.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MERCILESS_GLADIATOR.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafePlayer player, String event, Object data)
	{
		if (event.equals("peeveepee.rating.change") && (Integer) data == 2500)
			this.award(player);
	}
}
