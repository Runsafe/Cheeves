package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MasterOfMagic extends Achievement implements IPlayerCustomEvent
{
	public MasterOfMagic(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Master of Magic";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Win wizard PvP whilst using each of the schools of magic.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MASTER_OF_MAGIC.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.masterOfMagic"))
			award(event.getPlayer());
	}
}
