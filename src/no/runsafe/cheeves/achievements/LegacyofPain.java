package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class LegacyOfPain extends Achievement implements IPlayerCustomEvent
{
	public LegacyOfPain(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Legacy Of Pain";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the third Tunnel. ";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.LEGACY_OF_PAIN.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.legacyofpain"))
			award(event.getPlayer());
	}
}
