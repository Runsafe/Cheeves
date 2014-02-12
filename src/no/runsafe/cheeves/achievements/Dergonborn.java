package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Dergonborn extends Achievement implements IPlayerCustomEvent
{
	public Dergonborn(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Dergonborn";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Assist in the slaying of a dergon!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.DERGONBORN.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.dergon.kill"))
			award(event.getPlayer());
	}
}
