package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.AnyPlayerRequired;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.RequiredArgument;
import no.runsafe.framework.api.player.IPlayer;

public class AwardAchievement extends ExecutableCommand
{
	public AwardAchievement(AchievementHandler achievementHandler, AchievementFinder achievementFinder, IServer server)
	{
		super("awardach", "Awards an achievement to a player", "runsafe.cheeves.award", new AnyPlayerRequired(), new RequiredArgument("achievementID"));
		this.achievementHandler = achievementHandler;
		this.achievementFinder = achievementFinder;
		this.server = server;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IPlayer player = server.getPlayer(parameters.get("player"));

		if (player != null)
		{
			Achievement achievement = this.achievementFinder.getAchievementByID(Integer.valueOf(parameters.get("achievementID")));
			if (achievement == null)
				return "&cNo achievement with that ID.";

			this.achievementHandler.awardAchievement(achievement, player);
			return null;
		}
		return "&cUnable to find player";
	}

	private final AchievementHandler achievementHandler;
	private final AchievementFinder achievementFinder;
	private final IServer server;
}
