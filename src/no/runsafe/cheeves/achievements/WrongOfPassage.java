package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class WrongOfPassage extends Achievement implements IPlayerCustomEvent
{
	public WrongOfPassage(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Wrong Of Passage";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Found the entrance to the tunnel. ";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WRONG_OF_PASSAGE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.wrongofpassage"))
			award(event.getPlayer());
	}
