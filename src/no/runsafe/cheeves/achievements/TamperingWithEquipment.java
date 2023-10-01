package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TamperingWithEquipment extends Achievement implements IPlayerCustomEvent
{
	public TamperingWithEquipment(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Tampering With Equipment";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Locate and use the doorway control panel";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TAMPERING_WITH_EQUIPMENT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.tamperingwithequipment"))
			award(event.getPlayer());
	}
}
