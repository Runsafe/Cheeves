package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MarvellousMutiny extends Achievement implements IPlayerCustomEvent
{
	public MarvellousMutiny(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Marvellous Mutiny";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Murder the leader of your clan.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MARVELLOUS_MUTINY.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("runsafe.clans.mutiny"))
			award(event.getPlayer());
	}
}
