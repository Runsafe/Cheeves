package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class LandHo extends Achievement implements IPlayerCustomEvent
{
	public LandHo(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Land Ho";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtained the Treasure Chest Key and made it off Captain Flint's Ship.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.LAND_HO.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.landho"))
			award(event.getPlayer());
	}
}
