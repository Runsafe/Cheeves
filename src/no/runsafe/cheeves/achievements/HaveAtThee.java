package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class HaveAtThee extends Achievement implements IPlayerCustomEvent
{
	public HaveAtThee(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Have at Thee, Fiend!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Throw a snowball at a dergon.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.HAVE_AT_THEE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.dergons.snowball"))
			award(event.getPlayer());
	}
}
