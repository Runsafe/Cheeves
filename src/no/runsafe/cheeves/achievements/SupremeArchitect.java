package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.api.player.IAmbiguousPlayer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

import java.util.Map;

public class SupremeArchitect extends Achievement implements IPlayerCustomEvent
{
	public SupremeArchitect(AchievementHandler achievementHandler, IServer server)
	{
		super(achievementHandler);
		this.server = server;
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
		if (!event.getEvent().equals("creative.plot.approved"))
			return;

		Map<String, String> data = (Map<String, String>) event.getData();
		if (Integer.parseInt(data.get("approved_plots")) < 10)
			return;

		IPlayer player = server.getPlayer(data.get("owner"));
		if (player != null && !(player instanceof IAmbiguousPlayer))
			this.award(player);
	}

	private final IServer server;
}
