package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;

public class FleshWound extends AchievementDefinition implements IPlayerDeathEvent
{
	public FleshWound(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 13;

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		IPlayer killer = event.getEntity().getKiller();
		if (killer != null && killer.getHealth() == 1)
			this.award(killer, ID);
	}
}
