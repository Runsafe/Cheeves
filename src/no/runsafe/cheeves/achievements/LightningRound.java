package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class LightningRound extends Achievement implements IPlayerCustomEvent
{
	public LightningRound(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Lightning Round";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Witnessed and defeated a Lightning round in PvE.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.LIGHTNING_ROUND.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.lightninground"))
			award(event.getPlayer());
	}
}
