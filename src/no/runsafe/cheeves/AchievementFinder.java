package no.runsafe.cheeves;

import no.runsafe.cheeves.achievements.IAchievement;

import java.util.HashMap;
import java.util.Map;

public class AchievementFinder
{
	public AchievementFinder(IAchievement[] achievements)
	{
		for (IAchievement achievement : achievements)
			this.achievementHashMap.put(achievement.getAchievementID(), achievement);
	}

	public IAchievement getAchievementByID(int achievementID)
	{
		return (this.achievementHashMap.containsKey(achievementID) ? this.achievementHashMap.get(achievementID) : null);
	}

	public IAchievement getAchievementByTitle(String title)
	{
		IAchievement possibleMatch = null;
		for (Map.Entry<Integer, IAchievement> entry : this.achievementHashMap.entrySet())
		{
			IAchievement achievement = entry.getValue();
			if (achievement.getAchievementName().equalsIgnoreCase(title))
				return achievement;

			if (achievement.getAchievementName().startsWith(title))
				possibleMatch = achievement;
		}

		if (possibleMatch != null)
			return possibleMatch;

		return null;
	}

	private HashMap<Integer, IAchievement> achievementHashMap = new HashMap<Integer, IAchievement>();
}
