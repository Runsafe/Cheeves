package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MobGrinder extends Achievement implements IPlayerCustomEvent
{
	public MobGrinder(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Mob Grinder";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Play a game in one of the mob arenas.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MOB_GRINDER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.mobgrinder"))
			award(event.getPlayer());
	}
}