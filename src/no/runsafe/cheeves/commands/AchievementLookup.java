package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.Config;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.TrailingArgument;

public class AchievementLookup extends ExecutableCommand
{
	public AchievementLookup(AchievementFinder achievementFinder)
	{
		super("lookup", "Lookup information on an achievement", "runsafe.cheeves.lookup", new TrailingArgument("achievementTitle"));
		this.achievementFinder = achievementFinder;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IAchievement achievement = this.achievementFinder.getAchievementByTitle(parameters.getValue("achievementTitle"));
		if (achievement != null)
			return String.format(
				Config.Message.getAchievementLookup(),
				achievement.getAchievementName(),
				achievement.getAchievementInfo()
			);

		return Config.Message.getInvalidAchievement();
	}

	private final AchievementFinder achievementFinder;
}
