package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Backstabber extends Achievement implements IPlayerCustomEvent
{
	public Backstabber(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Backstabber";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Kill a member of your own clan.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.BACKSTABBER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.clans.backstabber"))
			award(event.getPlayer());
	}
}
