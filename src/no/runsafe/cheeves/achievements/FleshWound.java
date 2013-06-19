package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class FleshWound extends Achievement implements IPlayerDeathEvent
{
	public FleshWound(AchievementHandler achievementHandler, IOutput output)
	{
		super(achievementHandler);
		this.output = output;
	}

	@Override
	public String getAchievementName()
	{
		return "It's Just a Flesh Wound";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Kill a player while you're on half a heart of health.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.FLESH_WOUND.ordinal();
	}

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		RunsafePlayer victim = event.getEntity();
		this.output.write("Detected player death: " + victim.getName());
		if (victim.getLastDamageCause() instanceof RunsafeEntityDamageByEntityEvent)
		{
			this.output.write("The last damage cause was from an entity");
			RunsafeEntityDamageByEntityEvent damage = (RunsafeEntityDamageByEntityEvent) victim.getLastDamageCause();
			if (damage.getDamageActor() instanceof RunsafePlayer)
			{
				RunsafePlayer attacker = (RunsafePlayer) damage.getDamageActor();
				this.output.write("Attacker was a player: " + attacker.getName());
				this.output.write("Attackers health: " + attacker.getHealth());
				if (attacker.getHealth() == 1)
					this.award(attacker);
			}
		}
	}

	private IOutput output;
}
