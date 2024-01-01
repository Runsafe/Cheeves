package no.runsafe.cheeves;

import java.util.HashMap;
import java.util.Map;

public class AchievementFinder
{
	public AchievementFinder(Achievement[] achievements)
	{
		for (Achievement achievement : achievements)
			this.achievementHashMap.put(achievement.getAchievementID(), achievement);
	}

	public Achievement getAchievementByID(int achievementID)
	{
		return (this.achievementHashMap.getOrDefault(achievementID, null));
	}

	public Achievement getAchievement(Achievements achievement)
	{
		return this.getAchievementByID(achievement.ordinal());
	}

	public Achievement getAchievementByTitle(String title)
	{
		Achievement possibleMatch = null;
		for (Map.Entry<Integer, Achievement> entry : this.achievementHashMap.entrySet())
		{
			Achievement achievement = entry.getValue();
			if (achievement.getAchievementName().equalsIgnoreCase(title))
				return achievement;

			if (achievement.getAchievementName().toLowerCase().startsWith(title.toLowerCase()))
				possibleMatch = achievement;
		}

		return possibleMatch;
	}

	private final HashMap<Integer, Achievement> achievementHashMap = new HashMap<>();
}
