package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.PlayerArgument;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;
import java.util.Map;

public class ViewAchievements extends ExecutableCommand
{
	public ViewAchievements(AchievementFinder achievementFinder, AchievementHandler achievementHandler)
	{
		super("view", "Views achievements for yourself or another player", "runsafe.cheeves.view", new PlayerArgument(false));
		this.achievementFinder = achievementFinder;
		this.achievementHandler = achievementHandler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		RunsafePlayer viewPlayer = null;
		if (executor instanceof RunsafePlayer)
			viewPlayer = (RunsafePlayer) executor;

		if (parameters.containsKey("player"))
			viewPlayer = RunsafeServer.Instance.getPlayer(parameters.get("player"));

		if (viewPlayer == null)
			return "&cPlease specify a player when running this from the console.";

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

	private AchievementFinder achievementFinder;
	private AchievementHandler achievementHandler;
}
