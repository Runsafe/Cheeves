package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class DergonRide extends Achievement implements IPlayerCustomEvent
{
	public DergonRide(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "I Can See the Pub From 'Ere";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Take to the skies in the maw of a Dergon!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.DERGON_RIDE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.dergon.mount"))
			award(event.getPlayer());
	}
}
