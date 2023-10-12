package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class WrongTurn extends Achievement implements IPlayerCustomEvent
{
	public WrongTurn(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Wrong Turn";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Got lost in the Tunnel maze, and found a way out.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WRONG_TURN.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.wrongturn"))
			award(event.getPlayer());
	}
}
