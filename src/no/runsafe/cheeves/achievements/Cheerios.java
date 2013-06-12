package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class Cheerios extends Achievement implements IPlayerDeathEvent
{
	public Cheerios(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Poopin' In My Cheerios";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Kill a player who has 30 or more levels on them.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.CHEERIOS.ordinal();
	}

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		RunsafePlayer deadPlayer = event.getEntity();

		if (deadPlayer.getLevel() >= 30)
		{
			if (deadPlayer.getLastDamageCause() instanceof RunsafeEntityDamageByEntityEvent)
			{
				RunsafeEntityDamageByEntityEvent deathEvent = (RunsafeEntityDamageByEntityEvent) deadPlayer.getLastDamageCause();
				if (deathEvent.getDamageActor() instanceof RunsafePlayer)
					this.award((RunsafePlayer) deathEvent.getDamageActor());
			}
		}
	}
}
