package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class SomebodyLikesMe extends Achievement implements IPlayerCustomEvent
{
	public SomebodyLikesMe(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Somebody Likes Me!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Become a member of a clan.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SOMEBODY_LIKES_ME.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.clans.join"))
			award(event.getPlayer());
	}
}
