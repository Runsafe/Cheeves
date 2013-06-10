package no.runsafe.cheeves;

import no.runsafe.cheeves.achievements.IAchievement;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.player.RunsafePlayer;

public class AchievementHandler
{
	public void awardAchievement(IAchievement achievement, RunsafePlayer player)
	{
		RunsafeServer.Instance.broadcastMessage(String.format(
				"%s &ehas earned the achievement &3%s&e.",
				player.getPrettyName(),
				achievement.getAchievementName()
		));
	}
}
