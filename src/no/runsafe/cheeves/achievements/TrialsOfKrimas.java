package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TrialsOfKrimas extends Achievement implements IPlayerCustomEvent
{
	public TrialsOfKrimas(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Trials Of Krimas";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the trials of Krimas and made it to the wonderland.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TRIALS_OF_KRIMAS.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.trialsofkrimas"))
			award(event.getPlayer());
	}
}
