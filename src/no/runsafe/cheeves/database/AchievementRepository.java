package no.runsafe.cheeves.database;

import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.database.*;
import no.runsafe.framework.api.player.IPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AchievementRepository extends Repository
{
	public AchievementRepository(IServer server)
	{
		this.server = server;
	}

	@Override
	public String getTableName()
	{
		return "cheeves_data";
	}

	public HashMap<IPlayer, List<Integer>> getAchievements()
	{
		HashMap<IPlayer, List<Integer>> achievements = new HashMap<IPlayer, List<Integer>>();
		ISet data = this.database.query("SELECT playerName, achievementID FROM cheeves_data");
		for (IRow node : data)
		{
			IPlayer player = server.getPlayer(node.String("playerName"));
			if (player != null)
			{
				if (!achievements.containsKey(player))
					achievements.put(player, new ArrayList<Integer>());

				achievements.get(player).add(node.Integer("achievementID"));
			}
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

	public void storeAchievement(IPlayer player, IAchievement achievement, boolean toasted)
	{
		this.database.execute(
			"INSERT INTO cheeves_data (playerName, achievementID, earned, toasted) VALUES(?, ?, NOW(), ?)",
			player.getName().toLowerCase(),
			achievement.getAchievementID(),
			(toasted ? 1 : 0)
		);
	}

	@Override
	public ISchemaUpdate getSchemaUpdateQueries()
	{
		ISchemaUpdate update = new SchemaUpdate();

		update.addQueries(
			"CREATE TABLE `cheeves_data` (" +
				"`playerName` VARCHAR(50) NOT NULL," +
				"`achievementID` INT(10) NOT NULL," +
				"`earned` DATETIME NOT NULL," +
				"PRIMARY KEY (`playerName`, `achievementID`)" +
			")"
		);

		update.addQueries("ALTER TABLE `cheeves_data` ADD COLUMN `toasted` TINYINT(1) UNSIGNED NOT NULL DEFAULT '1' AFTER `earned`");

		return update;
	}

	private final IServer server;
}
