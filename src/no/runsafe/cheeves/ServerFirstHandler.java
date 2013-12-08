package no.runsafe.cheeves;

import no.runsafe.framework.api.event.plugin.IPluginEnabled;

import java.util.List;
import java.util.Map;

public class ServerFirstHandler implements IPluginEnabled
{
	public ServerFirstHandler(AchievementHandler handler, AchievementFinder finder)
	{
		this.handler = handler;
		this.finder = finder;
	}

	@Override
	public void OnPluginEnabled()
	{
		for (Map.Entry<String, List<Integer>> node : this.handler.getEarnedAchievements().entrySet())
			for (int achievementID : node.getValue())
				if (this.finder.getAchievementByID(achievementID) instanceof ServerFirstAchievement)
					this.handler.registerServerFirst(achievementID);
	}

	private final AchievementHandler handler;
	private final AchievementFinder finder;
}
