package no.runsafe.cheeves;

import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.framework.api.event.plugin.IPluginEnabled;
import no.runsafe.framework.api.player.IPlayer;

import java.util.List;
import java.util.Map;

public class ServerFirstHandler implements IPluginEnabled
{
	public ServerFirstHandler(AchievementHandler handler, AchievementDefinitionRepository repository)
	{
		this.handler = handler;
		this.repository = repository;
	}

	@Override
	public void OnPluginEnabled()
	{
		for (Map.Entry<IPlayer, List<Integer>> node : this.handler.getEarnedAchievements().entrySet())
			for (int achievementID : node.getValue())
				if (this.repository.getAchievementByID(achievementID).getServerFirst())
					this.handler.registerServerFirst(achievementID);
	}

	private final AchievementHandler handler;
	private final AchievementDefinitionRepository repository;
}
