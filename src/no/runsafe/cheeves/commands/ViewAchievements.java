package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Config;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.Player;
import no.runsafe.framework.api.player.IPlayer;

import java.util.List;

public class ViewAchievements extends ExecutableCommand
{
	public ViewAchievements(AchievementFinder achievementFinder, AchievementHandler achievementHandler)
	{
		super("view", "Views achievements for yourself or another player", "runsafe.cheeves.view", new Player().defaultToExecutor());
		this.achievementFinder = achievementFinder;
		this.achievementHandler = achievementHandler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IPlayer viewPlayer = parameters.getValue("player");

		if (viewPlayer == null)
			return Config.Message.getConsoleInvalidPlayer();

		List<Integer> achievements = this.achievementHandler.getPlayerAchievements(viewPlayer);

		if (achievements == null)
			return String.format(Config.Message.getNoAchievements(), viewPlayer.getName());

		executor.sendColouredMessage(Config.Message.getAchievementsListLine1(), viewPlayer.getPrettyName());
		for (Integer achievementID : achievements)
		{
			IAchievement achievement = this.achievementFinder.getAchievementByID(achievementID);
			executor.sendComplexMessage(
				String.format(Config.Message.getAchievementsListLine2(), achievement.getAchievementName()),
				String.format(Config.Message.getInfoColour(), achievement.getAchievementInfo()), null
			);
		}
		return null;
	}

	private final AchievementFinder achievementFinder;
	private final AchievementHandler achievementHandler;
}
