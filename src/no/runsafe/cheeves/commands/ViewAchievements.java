package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.PlayerArgument;
import no.runsafe.framework.api.player.IAmbiguousPlayer;
import no.runsafe.framework.api.player.IPlayer;

import java.util.List;

public class ViewAchievements extends ExecutableCommand
{
	public ViewAchievements(AchievementFinder achievementFinder, AchievementHandler achievementHandler, IServer server)
	{
		super("view", "Views achievements for yourself or another player", "runsafe.cheeves.view", new PlayerArgument(false));
		this.achievementFinder = achievementFinder;
		this.achievementHandler = achievementHandler;
		this.server = server;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IPlayer viewPlayer = null;
		if (executor instanceof IPlayer)
			viewPlayer = (IPlayer) executor;

		if (parameters.containsKey("player"))
			viewPlayer = server.getPlayer(parameters.get("player"));

		if (viewPlayer == null)
			return "&cPlease specify a player when running this from the console.";

		if (viewPlayer instanceof IAmbiguousPlayer)
			return viewPlayer.toString();

		List<Integer> achievements = this.achievementHandler.getPlayerAchievements(viewPlayer);

		if (achievements == null)
			return String.format("&3%s has no achievements.", viewPlayer.getName());

		executor.sendColouredMessage("Achievements earned by " + viewPlayer.getName());
		for (Integer achievementID : achievements)
		{
			IAchievement achievement = this.achievementFinder.getAchievementByID(achievementID);
			executor.sendColouredMessage("&3" + achievement.getAchievementName());
		}
		return null;
	}

	private final AchievementFinder achievementFinder;
	private final AchievementHandler achievementHandler;
	private final IServer server;
}
