package no.runsafe.cheeves.database;

import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.database.*;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AchievementDefinitionRepository extends Repository implements IConfigurationChanged
{
	@Nonnull
	@Override
	public String getTableName()
	{
		return "cheeves";
	}

	public List<ConfiguredAchievement> getAchievements()
	{
		List<ConfiguredAchievement> achievements = new ArrayList<>();
		ISet data = this.database.query("SELECT id, name, info, trigger, server_first FROM cheeves");
		for (IRow node : data)
		{
			ConfiguredAchievement achievement = new ConfiguredAchievement(
				node.Integer("id"),
				node.String("name"),
				node.String("info"),
				node.String("trigger"),
				node.Integer("server_first") == 1
			);

			achievements.add(achievement);
		}
		return achievements;
	}

	public void storeAchievement(int id, String name, String info, String triggerEvent, Boolean serverFirst)
	{
		this.database.execute(
			"INSERT INTO cheeves (id, name, info, trigger, server_first) VALUES(?, ?, ?, ?, ?)",
			id, name, info, triggerEvent, serverFirst ? 1 : 0
		);
	}

	@Nonnull
	@Override
	public ISchemaUpdate getSchemaUpdateQueries()
	{
		ISchemaUpdate update = new SchemaUpdate();

		update.addQueries(
			"CREATE TABLE `cheeves` (" +
				"`id` INT(10) NOT NULL," +
				"`name` VARCHAR(100) NOT NULL," +
				"`info` VARCHAR(500) NOT NULL," +
				"`trigger` VARCHAR(50) NOT NULL," +
				"`server_first` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0'," +
				"PRIMARY KEY (`id`)" +
			")",
			"INSERT INTO `cheeves` (`id`,`name`,`info`,`trigger`) VALUES" +
				"(0,'Gladiator','Earn a rating of 2000 in the PvP arena.','achievement.GLADIATOR')," +
				"(1,'Pimp','Obtain 64 blocks of diamond.','achievement.PIMP')," +
				"(2,'Let\\'s Build an Emerald City','Obtain 64 blocks of emerald.','achievement.EMERALD_CITY')," +
				"(3,'I Swear it Existed!','Completed the original tunnel event within the time limit.','achievement.TUNNEL')," +
				"(4,'Defense of the Kingdom','Partake in the Defense of the Kingdom event.','achievement.DEFENSE_OF_THE_KINGDOM')," +
				"(5,'PvP Tournament - June 2013','Partake in the PvP tournament of June 2013','achievement.PVP_TOURNAMENT_JUNE')," +
				"(7,'My Precious','Obtain a dragon egg.','achievement.MY_PRECIOUS')," +
				"(8,'Wizards Did It','Obtain a wizard head.','achievement.WIZARD_HEAD')," +
				"(9,'Shield-wall','Take damage from the following mobs without dying: Blaze, Cave Spider, Enderman, Creeper, Ghast, Lava Slime, Iron Golem, Zombie Pigman, Silverfish, Skeleton, Zombie, Witch, Wither, Wolf, Slime, Spider.','achievement.SHIELDWALL')," +
				"(10,'When I\\'m Cleaning Windows','Obtain a sponge.','achievement.SPONGE')," +
				"(11,'Wicked Sick','Earn a wicked sick killing spree in PvP','peeveepee.killspree.wickedsick')," +
				"(12,'Merciless Gladiator','Earn a rating of 2500 in PvP.','achievement.MERCILESS_GLADIATOR')," +
				"(13,'It\\'s Just a Flesh Wound','Kill a player while you\\'re on half a heart of health.','achievement.FLESH_WOUND')," +
				"(14,'Did Someone Order a Knuckle Sandwich?','Deal 100 points of damage to a wither using your fists without dying.','achievement.KNUCKLE_SANDWICH')," +
				"(15,'Poopin\\' In My Cheerios','Kill a player who has 30 or more levels on them.','achievement.CHEERIOS')," +
				"(16,'What are the odds?','Get struck by lightning in survival.','achievement.WHAT_ARE_THE_ODDS')," +
				"(17,'Sewage Survivor','Survive in the sewers for five minutes without invisibility potions.','achievement.SEWAGE_SURVIVOR')," +
				"(18,'Lightning Really Does Strike Twice','Get struck by lightning twice!','achievement.LIGHTNING_STRIKES_TWICE')," +
				"(19,'I Made That','Have one of your creative plots approved.','achievement.I_MADE_THAT')," +
				"(20,'Supreme Architect','Have 10 of your plots approved!','achievement.SUPREME_ARCHITECT')," +
				"(21,'My Brain Hurts','Complete the July 2013 puzzle server event.','achievement.MY_BRAIN_HURTS')," +
				"(23,'Dweller of the Vaults','Break into the bank vault and access the loots.','achievement.VAULT_DWELLER')," +
				"(24,'Spleef Tournament - August 2013','Partake in the spleef tournament of August 2013','achievement.SPLEEF_TOURNAMENT_AUGUST')," +
				"(25,'Winner: Spleef Tournament - August 2013','Proud winner of the spleef tournament of August 2013','achievement.SPLEEF_TOURNAMENT_AUGUST_WINNER')," +
				"(26,'Survival Challenge','Partake in the Survival Challenge.','achievement.survivalChallenge')," +
				"(27,'Survival Challenge: Winner','Winner of the Survival Challenge!','achievement.survivalChallengeWinner')," +
				"(28,'Master of Magic','Score first place in a match of wizard PvP.','achievement.masterOfMagic')," +
				"(29,'Apprentice Wizard','Score in the top three for a match of wizard PvP.','achievement.apprenticeWizard')," +
				"(30,'Touch of Death','Kill a player in Wizard PvP while being in the graveyard.','achievement.touchOfDeath')," +
				"(31,'My First Steps Into Misery','Complete the first stage of The Tunnel mini-game.','achievement.tunnel1')," +
				"(32,'Painful Progression','Complete the second stage of The Tunnel mini-game.','achievement.tunnel2')," +
				"(33,'Master of the Madness','Complete the third stage of The Tunnel mini-game.','achievement.tunnel3')," +
				"(34,'Insane in the Membrane','Complete the fourth stage of The Tunnel mini-game.','achievement.tunnel4')," +
				"(35,'Will This Ever End?','Complete the fifth stage of The Tunnel mini-game.','achievement.tunnel5')," +
				"(36,'Somebody Likes Me!','Become a member of a clan.','runsafe.clans.join')," +
				"(37,'Backstabber','Kill a member of your own clan.','runsafe.clans.backstabber')," +
				"(38,'Marvellous Mutiny','Murder the leader of your clan.','runsafe.clans.mutiny')," +
				"(39,'What Year Is It?!','Complete the tunnel mini-game.','achievement.tunnelEnd')," +
				"(40,'Dergonborn','Assist in the slaying of a dergon!','runsafe.dergon.kill')," +
				"(41,'Have at Thee, Fiend!','Throw a snowball at a dergon.','runsafe.dergons.snowball')," +
				"(42,'Bullseye','Shoot a player with an arrow from over 40 blocks away.','achievement.BULLSEYE')," +
				"(43,'I Can See the Pub From \\'Ere','Take to the skies in the maw of a Dergon!','runsafe.dergon.mount')," +
				"(44,'Fishies be mine! Leave dem fishies!','Winner of the weekly fishing tournament!','fishing.tournament.win')," +
				"(45,'The Scavenger','Fish up one of the rare special items from spawn!','fishing.special.loot')," +
				"(46,'Shipwrecked!','Complete The Adventure server event.','achievement.NUMBERS_MASON')," +
				"(47,'Suddenly, silverfish!','Activate a dungeon in Azuren.','azuren.dungeon.event')," +
				"(48,'Flint\\'s Gold Hoarder','Obtain 25 pieces Captain Flints Gold','achievement.FLINTS_GOLD_HOARDER')," +
				"(49,'Open Sorcerer','Contribute to the source code of the Runsafe server!','achievement.OPEN_SORCERER')," +
				"(50,'Master Fisherman','Obtain 2000 cooked fish.','achievement.MASTER_FISHERMAN')," +
				"(51,'Land Ho','Obtained the Treasure Chest Key and made it off Captain Flint\\'s Ship.','achievement.landho')," +
				"(52,'Pirates Always Get Thar Hands Dirty','Obtained the Bone of the dead and made it out of Flint\\'s Graveyard.','achievement.deadbone')," +
				"(53,'All t\\' Mates Loved That Flower','Obtained the Beloved Dandelion and made it out of The Sand Maze.','achievement.belovedflower')," +
				"(54,'Why Are Pearls So Shiny?','Obtained Barleria\\'s Pearl and made it out of The Cave.','achievement.barleriapeal')," +
				"(55,'What Happens Inside That Tiny Head?','Obtained the Silverfish Brain Piece and made it out of The Silverfish Lair.','achievement.silverfishmind')," +
				"(57,'Master Treasure Hunter','Found the lost treasure of Captain Flint!','achievement.mastertreasurehunter')," +
				"(58,'Huckleberry Beta','Obtain 100 Beta tokens.','achievement.HUCKLEBERRY_BETA')," +
				"(59,'It\\'s Lonely at the Top','Win a match of LMS.','achievement.masterFighter')," +
				"(60,'Parkour: Red Course','Complete the Red Course in the Parkour world.','achievement.parkourred')," +
				"(61,'CTF Event March 2015','Participated in the March 2015 CTF Event!','achievement.ctfeventmarch')," +
				"(62,'CTF Event Victor - March 2015','Won a game in the March 2015 CTF Event!','achievement.ctfeventmarchvictor')," +
				"(63,'Hey Big Spender','Embark on a rather expensive shopping spree!','achievement.bigSpender')," +
				"(64,'Open Pockets','Give 20 coins or more to another player.','achievement.openPockets')," +
				"(65,'Money Makes the World Go Around','Earn a total of 500 coins!','achievement.coins')," +
				"(66,'Gold Goblin','Earn a total of 1000 coins!','achievement.coins2')," +
				"(67,'The Bread Winner','Earn a total of 10,000 coins!','achievement.coins3')," +
				"(68,'Parkour: Yellow Course','Complete the Yellow Course in the Parkour world.','achievement.parkouryellow')," +
				"(69,'Mob Grinder','Complete all five rounds in any arena.','achievement.mobgrinder')," +
				"(70,'Vanish','Purchase a Vanish spell from the PVE Shop.','achievement.vanish')," +
				"(71,'Welcome To The Club','Enter the Secret Room in PVE.','achievement.welcometotheclub')," +
				"(72,'Top Consumer','Buy an item from the PvE shop.','achievement.topconsumer')," +
				"(73,'PvE Master','Have a total of 1000 PvE Points at once.','achievement.pvemaster')," +
				"(74,'PvE Novice','Have a total of 50 PvE Points at once.','achievement.pvenovice')," +
				"(75,'PvE Apprentice','Have a total of 100 PvE Points at once.','achievement.pveapprentice')," +
				"(76,'PvE Expert','Have a total of 500 PvE Points at once.','achievement.pveexpert')," +
				"(77,'Time Capsule','Enter the Secret Room in the Survival Spawn.','achievement.timecapsule')," +
				"(78,'Surface Champion','Beat all 5 Rounds of the Surface Arena.','achievement.surfacechampion')," +
				"(79,'Survival Smarts','Traded a Dergon Egg for Dergon bones.','achievement.survivalsmarts')," +
				"(80,'Mine Champion','Beat all 5 Rounds of the Mine Arena.','achievement.minechampion')," +
				"(81,'PvE Spender','Made a purchase in the PVE Minigame.','achievement.pvespender')," +
				"(82,'Nether Champion','Beat all 5 Rounds of the Nether Arena.','achievement.netherchampion')," +
				"(83,'Lightning Round','Witnessed and defeated a Lightning round in PvE.','achievement.lightninground')," +
				"(84,'Halloween 2023','Participated in the Halloween 2023 Event','achievement.halloween2023')," +
				"(85,'Master Spook','Completed the Halloween 2023 Event','achievement.masterspook')," +
				"(86,'Snooping Around','Find the primary drainage tunnel.','achievement.snoopingaround')," +
				"(87,'Could Be Worse','Find the primary drainage basin','achievement.couldbeworse')," +
				"(88,'Tampering With Equipment','Locate and use the doorway control panel','achievement.tamperingwithequipment')," +
				"(89,'Where Could They Be','Find the doorway control panel','achievement.wherecouldtheybe')," +
				"(90,'Top Excavator','Found all 6 gravesites and obtained the moosic records.','achievement.topexcavator')," +
				"(91,'Wrong Turn','Got lost in the Tunnel maze, and found a way out.','achievement.wrongturn')," +
				"(92,'Legacy Of Pain','Completed the third Tunnel.','achievement.legacyofpain')," +
				"(93,'Wrong Of Passage','Found the entrance to the tunnel.','achievement.wrongofpassage')," +
				"(94,'Parkour Novice','Completed the Novice rated parkour course.','achievement.parkournovice')," +
				"(95,'Parkour Competent','Completed the Competent rated parkour course.','achievement.parkourcompetent')," +
				"(96,'Dungeon Crawler','Found the dungeon on TracerON in spawn.','achievement.dungeoncrawler')," +
				"(97,'Parkour Master','Completed the Master rated parkour course.','achievement.parkourmaster')," +
				"(98,'Krimas','Participated in the Krimas Event','achievement.krimas')," +
				"(99,'Krimas Claus','Completed the Krimas Event','achievement.krimasclaus')," +
				"(100,'Trials Of Krimas','Completed the trials of Krimas and made it to the wonderland.','achievement.trialsofkrimas')," +
				"(101,'Krimas Elf','Located all 18 gifts in the wonderland.','achievement.krimaself')," +
				"(102,'Too Personal','Made DOG a little too uncomfortable.','runsafe.dog.uncomfortable')," +
				"(103,'Moosic Madness','Contribute to the endless Moosic library of Runsafe!','achievement.MOOSIC_MADNESS')," +
				"(104,'Temple Of The Unknown','Located the Temple Of The Unknown','achievement.templeunknown')",
			"INSERT INTO `cheeves` (`id`,`name`,`info`,`trigger`,`server_first`) VALUES" +
				"(6,'Server First: Ender Dragon','Participate in the server-first ender dragon kill.','achievement.SERVER_FIRST_ENDER_DRAGON',1)," +
				"(22,'Server First: My Brain Hurts','Be the first player to complete the July 2013 puzzle event.','achievement.SERVER_FIRST_MY_BRAIN_HURTS',1)," +
				"(56,'Server First: Master Treasure Hunter','Was either the first person or group to reach Captain Flint\\'s lost treasure!','achievement.SERVER_FIRST_MASTER_TREASURE_HUNTER',1)," +
			"ALTER TABLE `cheeves` MODIFY COLUMN `id` INT(10) NOT NULL AUTO_INCREMENT",
			"ALTER TABLE `cheeves` AUTO_INCREMENT=105"
		);

		return update;
	}

	@Override
	public void OnConfigurationChanged(IConfiguration configuration)
	{
		for(IAchievement achievement : getAchievements())
		{
			this.achievementHashMap.put(achievement.getAchievementID(), achievement);
		}
	}

	public IAchievement getAchievementByID(int achievementID)
	{
		return (this.achievementHashMap.getOrDefault(achievementID, null));
	}

	public IAchievement getAchievementByTitle(String title)
	{
		IAchievement possibleMatch = null;
		for (Map.Entry<Integer, IAchievement> entry : this.achievementHashMap.entrySet())
		{
			IAchievement achievement = entry.getValue();
			if (achievement.getAchievementName().equalsIgnoreCase(title))
				return achievement;

			if (achievement.getAchievementName().toLowerCase().startsWith(title.toLowerCase()))
				possibleMatch = achievement;
		}

		return possibleMatch;
	}

	private final HashMap<Integer, IAchievement> achievementHashMap = new HashMap<>();
}
