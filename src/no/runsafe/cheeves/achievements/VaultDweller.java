package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class VaultDweller extends Achievement
{
	public VaultDweller(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Dweller of the Vaults";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Break into the bank vault and access the loots.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.VAULT_DWELLER.ordinal();
	}
}
