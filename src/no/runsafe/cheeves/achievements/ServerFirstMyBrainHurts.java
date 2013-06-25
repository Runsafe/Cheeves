package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ServerFirstMyBrainHurts extends Achievement implements IPlayerCustomEvent
{
	public ServerFirstMyBrainHurts(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Server First: My Brain Hurts";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Be the first player to complete the July 2013 puzzle event.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SERVER_FIRST_MY_BRAIN_HURTS.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.myBrainHurts"))
			this.award(event.getPlayer());
	}
}
