package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class DeadBone extends Achievement implements IPlayerCustomEvent
{
	public DeadBone(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Pirates always get thar hands dirty";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtained the Bone of the dead and made it out of Flint's Graveyard.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.DEAD_BONE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.deadbone"))
			award(event.getPlayer());
	}
}
