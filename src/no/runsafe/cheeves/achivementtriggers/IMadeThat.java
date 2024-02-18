package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.api.player.IAmbiguousPlayer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

import java.util.Map;

public class IMadeThat extends AchievementDefinition implements IPlayerCustomEvent
{
	public IMadeThat(AchievementDefinitionRepository repository, AchievementHandler achievementHandler, IServer server)
	{
		super(repository, achievementHandler);
		this.server = server;
	}

	public static final int ID = 19;

	@SuppressWarnings("unchecked")
	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (!event.getEvent().equals("creative.plot.approved"))
			return;

		Map<String, String> data = (Map<String, String>) event.getData();
		IPlayer player = server.getPlayer(data.get("owner"));
		if (player != null && !(player instanceof IAmbiguousPlayer))
			this.award(player, ID);
	}

	private final IServer server;
}
