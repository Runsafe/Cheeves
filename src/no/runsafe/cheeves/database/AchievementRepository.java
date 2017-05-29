package no.runsafe.cheeves.database;

import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.database.*;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.api.server.IPlayerProvider;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AchievementRepository extends Repository
{
	public AchievementRepository(IPlayerProvider playerProvider)
	{
		this.playerProvider = playerProvider;
	}

	@Nonnull
	@Override
	public String getTableName()
	{
		return "cheeves_data";
	}

	public HashMap<IPlayer, List<Integer>> getAchievements()
	{
		HashMap<IPlayer, List<Integer>> achievements = new HashMap<IPlayer, List<Integer>>();
		ISet data = this.database.query("SELECT player, achievementID FROM cheeves_data");
		for (IRow node : data)
		{
			String playerID = node.String("player");
			if (playerID.length() != 36)
				continue;
			IPlayer player = playerProvider.getPlayer(UUID.fromString(playerID));
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
			"SELECT achievementID FROM cheeves_data WHERE player = ? AND toasted = 0",
			player.getUniqueId().toString()
		);
	}

	public void clearNonToastedAchievements(IPlayer player)
	{
		this.database.execute("UPDATE cheeves_data SET toasted = 1 WHERE player = ? AND toasted = 0", player.getUniqueId().toString());
	}

	public void storeAchievement(IPlayer player, IAchievement achievement, boolean toasted)
	{
		this.database.execute(
			"INSERT INTO cheeves_data (player, achievementID, earned, toasted) VALUES(?, ?, NOW(), ?)",
			player.getUniqueId().toString(),
			achievement.getAchievementID(),
			(toasted ? 1 : 0)
		);
	}

	@Nonnull
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

		update.addQueries(String.format("ALTER TABLE `%s` ADD COLUMN `toasted` TINYINT(1) UNSIGNED NOT NULL DEFAULT '1' AFTER `earned`", getTableName()));

		update.addQueries(
			String.format("ALTER TABLE `%s` CHANGE `playerName` `player` varchar(50) NOT NULL", getTableName()),
			String.format(// Update player UUIDs
				"UPDATE IGNORE `%s` SET `player` = " +
					"COALESCE((SELECT `uuid` FROM player_db WHERE `name`=`%s`.`player`), `player`) " +
					"WHERE length(`player`) != 36",
				getTableName(), getTableName()
			)
		);

		return update;
	}

	private final IPlayerProvider playerProvider;
}
