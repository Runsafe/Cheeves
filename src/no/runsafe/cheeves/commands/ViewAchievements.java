package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;
import java.util.Map;

public class ViewAchievements extends ExecutableCommand
{
	public ViewAchievements(AchievementFinder achievementFinder, AchievementHandler achievementHandler)
	{
		super("view", "Views achievements for yourself or another player", "runsafe.cheeves.view");
		this.achievementFinder = achievementFinder;
		this.achievementHandler = achievementHandler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		return null;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters, String[] arguments)
	{
		RunsafePlayer viewPlayer;
		if (executor instanceof RunsafePlayer)
		{
			viewPlayer = (arguments.length > 0 ? RunsafeServer.Instance.getPlayer(arguments[0]) : (RunsafePlayer) executor);
		}
		else
		{
			if (arguments.length > 0)
				viewPlayer = RunsafeServer.Instance.getPlayer(arguments[0]);
			else
				return "&cPlease specify a player when running this from the console.";
		}

		if (viewPlayer != null)
		{
			if (viewPlayer instanceof RunsafeAmbiguousPlayer)
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
		return "&cUnable to draw achievement list for that player.";
	}

	private AchievementFinder achievementFinder;
	private AchievementHandler achievementHandler;
}
