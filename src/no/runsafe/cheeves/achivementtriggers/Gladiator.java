package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Gladiator extends AchievementDefinition implements IPlayerCustomEvent
{
	public Gladiator(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 0;

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("peeveepee.rating.change") && (Integer) event.getData() >= 2000)
			this.award(event.getPlayer(), ID);
	}
}
