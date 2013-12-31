package no.runsafe.cheeves.database;

import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;
import no.runsafe.framework.api.database.Repository;
import no.runsafe.framework.api.player.IPlayer;

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
		ISet data = this.database.query("SELECT playerName, achievementID FROM cheeves_data");
		for (IRow node : data)
		{
			String playerName = node.String("playerName");
			if (!achievements.containsKey(playerName))
				achievements.put(playerName, new ArrayList<Integer>());

			achievements.get(playerName).add(node.Integer("achievementID"));
		}
		return achievements;
	}

	public List<Integer> getNonToastedAchievements(IPlayer player)
	{
		return this.database.queryIntegers(
			"SELECT achievementID FROM cheeves_data WHERE playerName = ? AND toasted = 0",
			player.getName().toLowerCase()
		);
	}

	public void clearNonToastedAchievements(IPlayer player)
	{
		this.database.execute("UPDATE cheeves_data SET toasted = 1 WHERE playerName = ? AND toasted = 0", player.getName().toLowerCase());
	}

	public void storeAchievement(String playerName, IAchievement achievement, boolean toasted)
	{
		this.database.execute(
			"INSERT INTO cheeves_data (playerName, achievementID, earned, toasted) VALUES(?, ?, NOW(), ?)",
			playerName.toLowerCase(),
			achievement.getAchievementID(),
			(toasted ? 1 : 0)
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

		sql.clear();
		sql.add(
			"ALTER TABLE `cheeves_data`" +
				"ADD COLUMN `toasted` TINYINT(1) UNSIGNED NOT NULL DEFAULT '1' AFTER `earned`;"
		);
		queries.put(2, sql);
		return queries;
	}

	private final IDatabase database;
}
