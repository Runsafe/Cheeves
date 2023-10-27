package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class DungeonCrawler extends Achievement implements IPlayerCustomEvent
{
	public DungeonCrawler(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Dungeon Crawler";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Found the dungeon on TracerON in spawn.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.DUNGEON_CRAWLER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.dungeoncrawler"))
			award(event.getPlayer());
	}
}
