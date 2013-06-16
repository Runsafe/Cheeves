package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class WickedSick extends Achievement implements IPlayerCustomEvent
{
	public WickedSick(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Wicked Sick";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a wicked sick killing spree in PvP";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WICKED_SICK.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafePlayer player, String event, Object data)
	{
		if (event.equals("peeveepee.killspree.wickedsick"))
			this.award(player);
	}
}
