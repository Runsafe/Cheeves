package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.*;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.Player;
import no.runsafe.framework.api.command.argument.WholeNumber;
import no.runsafe.framework.api.player.IPlayer;

public class AwardAchievement extends ExecutableCommand
{
	public AwardAchievement(AchievementHandler achievementHandler, AchievementDefinitionRepository repository)
	{
		super("awardach", "Awards an achievement to a player", "runsafe.cheeves.award", new Player().require(), new WholeNumber("achievementID").require());
		this.achievementHandler = achievementHandler;
		this.repository = repository;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IPlayer player = parameters.getValue("player");

		if (player == null)
			return Config.Message.getInvalidPlayer();

		Integer id = parameters.getValue("achievementID");
		IAchievement achievement = null;
		if (id != null)
			achievement = this.repository.getAchievementByID(id);
		if (achievement == null)
			return Config.Message.getInvalidAchievementID();

		this.achievementHandler.awardAchievement(achievement, player);
		return null;
	}

	private final AchievementHandler achievementHandler;
	private final AchievementDefinitionRepository repository;
}
