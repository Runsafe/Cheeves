package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerDamageEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;

public class LightningStrikesTwice extends Achievement implements IPlayerDamageEvent
{

	public LightningStrikesTwice(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Lightning Really Does Strike Twice";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Get struck by lightning twice!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.LIGHTNING_STRIKES_TWICE.ordinal();
	}

	@Override
	public void OnPlayerDamage(IPlayer player, RunsafeEntityDamageEvent event)
	{
		if (player.isInUniverse("survival") && event.getCause() == RunsafeEntityDamageEvent.RunsafeDamageCause.LIGHTNING)
			if (this.achievementHandler.hasAchievement(player, Achievements.WHAT_ARE_THE_ODDS.ordinal()))
				this.award(player);
	}
}
