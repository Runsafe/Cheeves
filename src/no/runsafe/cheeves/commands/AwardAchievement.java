package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.Player;
import no.runsafe.framework.api.command.argument.WholeNumber;
import no.runsafe.framework.api.player.IPlayer;

public class AwardAchievement extends ExecutableCommand
{
	public AwardAchievement(AchievementHandler achievementHandler, AchievementFinder achievementFinder)
	{
		super("awardach", "Awards an achievement to a player", "runsafe.cheeves.award", new Player.Any.Required(), new WholeNumber("achievementID").require());
		this.achievementHandler = achievementHandler;
		this.achievementFinder = achievementFinder;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IPlayer player = parameters.getValue("player");

		if (player != null)
		{
			Integer id = parameters.getValue("achievementID");
			Achievement achievement = null;
			if (id != null)
				achievement = this.achievementFinder.getAchievementByID(id);
			if (achievement == null)
				return "&cNo achievement with that ID.";

			this.achievementHandler.awardAchievement(achievement, player);
			return null;
		}
		return "&cUnable to find player";
	}

	private final AchievementHandler achievementHandler;
	private final AchievementFinder achievementFinder;
}
