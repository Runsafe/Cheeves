package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.cheeves.achievementmetas.KnuckleSandwichMeta;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;

import java.util.HashMap;

public class KnuckleSandwich extends Achievement implements IEntityDamageByEntityEvent, IPlayerDeathEvent
{
	public KnuckleSandwich(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Did Someone Order a Knuckle Sandwich?";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Deal 100 points of damage to a wither using your fists without dying.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.KNUCKLE_SANDWICH.ordinal();
	}

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		String playerName = event.getEntity().getName();
		if (this.meta.containsKey(playerName))
			this.meta.get(playerName).resetDamage();
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		RunsafeEntity entity = event.getEntity();
		if (event.getDamageActor() instanceof IPlayer && entity.getEntityType() == LivingEntity.Wither)
		{
			IPlayer player = (IPlayer) event.getDamageActor();

			if (player.isInUniverse("survival"))
			{
				String playerName = player.getName();
				KnuckleSandwichMeta meta = (this.meta.containsKey(playerName) ? this.meta.get(playerName) : new KnuckleSandwichMeta(entity));

				if (!meta.isSameEntity(entity) || player.getItemInHand() == null || player.getItemInHand().is(Item.Unavailable.Air))
				{
					meta.resetDamage();
					meta.setEntity(entity);
				}
				else
				{
					if (meta.getDamage() == 100)
						this.award(player);
					else
						meta.addDamagePoint((int) event.getDamage());
				}
			}
		}
	}

	final HashMap<String, KnuckleSandwichMeta> meta = new HashMap<String, KnuckleSandwichMeta>();
}