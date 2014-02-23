package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class FishingTournamentWin extends Achievement implements IPlayerCustomEvent
{
	public FishingTournamentWin(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Fishies be mine! Leave dem fishies!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Winner of the weekly fishing tournament!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.FISHING_TOURNAMENT_WIN.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("fishing.tournament.win"))
			award(event.getPlayer());
	}
}
