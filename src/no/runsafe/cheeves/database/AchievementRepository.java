package no.runsafe.cheeves.database;

import no.runsafe.cheeves.achievements.IAchievement;
import no.runsafe.framework.database.IDatabase;
import no.runsafe.framework.database.Repository;
import no.runsafe.framework.database.Row;
import no.runsafe.framework.database.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AchievementRepository extends Repository
{
	public AchievementRepository(IDatabase database)
	{
		this.database = database;
	}

	@Override
	public String getTableName()
	{
		return "cheeves_data";
	}

	public HashMap<String, List<Integer>> getAchievements()
	{
		HashMap<String, List<Integer>> achievements = new HashMap<String, List<Integer>>();
		Set data = this.database.Query("SELECT playerName, achievementID FROM cheeves_data");

		if (data != null)
		{
			for (Row node : data)
			{
				String playerName = node.String("playerName");
				if (!achievements.containsKey(playerName))
					achievements.put(playerName, new ArrayList<Integer>());

				achievements.get(playerName).add(node.Integer("achievementID"));
			}
		}

		return achievements;
	}

	public void storeAchievement(String playerName, IAchievement achievement)
	{
		this.database.Execute(
				"INSERT INTO cheeves_data (playerName, achievementID, earned) VALUES(?, ?, NOW())",
				playerName,
				achievement.getAchievementID()
		);
	}

	@Override
	public HashMap<Integer, List<String>> getSchemaUpdateQueries()
	{
		HashMap<Integer, List<String>> queries = new HashMap<Integer, List<String>>();
		ArrayList<String> sql = new ArrayList<String>();
		sql.add(
				"CREATE TABLE `cheeves_data` (" +
						"`playerName` VARCHAR(50) NOT NULL," +
						"`achievementID` INT(10) NOT NULL," +
						"`earned` DATETIME NOT NULL," +
						"PRIMARY KEY (`playerName`, `achievementID`)" +
					")"
		);
		queries.put(1, sql);
		return queries;
	}

	private IDatabase database;
}
