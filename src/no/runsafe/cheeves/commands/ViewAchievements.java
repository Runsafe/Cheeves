package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.Config;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.Player;
import no.runsafe.framework.api.player.IPlayer;

import java.util.List;

public class ViewAchievements extends ExecutableCommand
{
	public ViewAchievements(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super("view", "Views listeners for yourself or another player", "runsafe.cheeves.view", new Player().defaultToExecutor());
		this.repository = repository;
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
			IAchievement achievement = this.repository.getAchievementByID(achievementID);
			executor.sendComplexMessage(
				String.format(Config.Message.getAchievementsListLine2(), achievement.getAchievementName()),
				String.format(Config.Message.getInfoColour(), achievement.getAchievementInfo()), null
			);
		}
		return null;
	}

	private final AchievementDefinitionRepository repository;
	private final AchievementHandler achievementHandler;
}
