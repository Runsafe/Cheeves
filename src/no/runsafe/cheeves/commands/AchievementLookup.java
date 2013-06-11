package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.internal.command.ExecutableCommand;

import java.util.HashMap;

public class AchievementLookup extends ExecutableCommand
{
	public AchievementLookup(AchievementFinder achievementFinder)
	{
		super("lookup", "Lookup information on an achievement", "runsafe.cheeves.lookup", "achievementTitle");
		this.captureTail();

		this.achievementFinder = achievementFinder;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		IAchievement achievement = this.achievementFinder.getAchievementByTitle(parameters.get("achievementTitle"));
		if (achievement != null)
			return String.format("&3%s - &f%s", achievement.getAchievementName(), achievement.getAchievementInfo());

		return "&cSorry, no achievement with that title could be found.";
	}

	private AchievementFinder achievementFinder;
}
