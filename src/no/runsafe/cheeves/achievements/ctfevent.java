package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MasterTreasureHunter extends Achievement implements IPlayerCustomEvent
{
	public MasterTreasureHunter(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "CTF Event March 2014";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Participated in the March 2014 CTF Event!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.CTF_EVENT_MARCH.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.ctfeventmarch"))
			award(event.getPlayer());
	}
}
