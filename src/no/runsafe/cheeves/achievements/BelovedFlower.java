package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class BelovedFlower extends Achievement implements IPlayerCustomEvent
{
	public BelovedFlower(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "All t' Mates Loved That Flower";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtained the Beloved Dandelion and made it out of The Sand Maze.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.BELOVED_FLOWER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.belovedflower"))
			award(event.getPlayer());
	}
}
