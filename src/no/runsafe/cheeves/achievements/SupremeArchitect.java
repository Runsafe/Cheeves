package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

import java.util.Map;

public class SupremeArchitect extends Achievement implements IPlayerCustomEvent
{
	public SupremeArchitect(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Supreme Architect";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Have 10 of your plots approved!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SUPREME_ARCHITECT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("creative.plot.approved"))
		{
			Map<String, String> data = (Map<String, String>) event.getData();
			if (Integer.valueOf(data.get("approved_plots")) >= 10)
				this.award(RunsafeServer.Instance.getPlayerExact(data.get("owner")));
		}
	}
}
