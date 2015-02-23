package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MasterFighter extends Achievement implements IPlayerCustomEvent
{
	public MasterFighter(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "It's Lonely At The Top";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Win a match of LMS.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MASTER_FIGHTER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.masterFighter"))
			award(event.getPlayer());
	}
}
