package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TooPersonal extends Achievement implements IPlayerCustomEvent
{
	public TooPersonal(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Too Personal";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Made DOG a little too uncomfortable.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TOO_PERSONAL.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.dog.uncomfortable"))
			award(event.getPlayer());
	}
}
