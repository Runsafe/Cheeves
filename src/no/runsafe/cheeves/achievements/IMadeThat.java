package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;
import no.runsafe.framework.minecraft.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.Map;

public class IMadeThat extends Achievement implements IPlayerCustomEvent
{
	public IMadeThat(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "I Made That";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Have one of your creative plots approved.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.I_MADE_THAT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("creative.plot.approved"))
		{
			Map<String, String> data = (Map<String, String>) event.getData();
			RunsafePlayer player = RunsafeServer.Instance.getPlayer(data.get("owner"));
			if (player != null && !(player instanceof RunsafeAmbiguousPlayer))
				this.award(player);
		}
	}
}
