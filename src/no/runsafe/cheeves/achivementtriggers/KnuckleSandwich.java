package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.achievementmetas.KnuckleSandwichMeta;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;

import java.util.HashMap;

public class KnuckleSandwich extends AchievementDefinition implements IEntityDamageByEntityEvent, IPlayerDeathEvent
{
	public KnuckleSandwich(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 14;

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		IPlayer player = event.getEntity();
		if (this.meta.containsKey(player))
			this.meta.get(player).resetDamage();
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		RunsafeEntity entity = event.getEntity();
		if (!(event.getDamageActor() instanceof IPlayer) || entity.getEntityType() != LivingEntity.Wither)
			return;

		IPlayer player = (IPlayer) event.getDamageActor();

		if (!player.isInUniverse("survival"))
			return;

		KnuckleSandwichMeta meta = (this.meta.containsKey(player) ? this.meta.get(player) : new KnuckleSandwichMeta(entity));

		if (!meta.isSameEntity(entity) || player.getItemInMainHand() == null || player.getItemInMainHand().is(Item.Unavailable.Air))
		{
			meta.resetDamage();
			meta.setEntity(entity);
			return;
		}

		if (meta.getDamage() == 100)
			this.award(player, ID);
		else
			meta.addDamagePoint((int) event.getDamage());
	}

	final HashMap<IPlayer, KnuckleSandwichMeta> meta = new HashMap<>();
}