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
		return "Master Treasure Hunter";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Found the lost treasure of Captain Flint!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MASTER_TREASURE_HUNTER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.mastertreasurehunter"))
			award(event.getPlayer());
	}
}
