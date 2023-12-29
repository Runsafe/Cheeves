package no.runsafe.cheeves;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;

public class Config implements IConfigurationChanged
{
	@Override
	public void OnConfigurationChanged(IConfiguration config)
	{
		Message.announce = config.getConfigValueAsString("message.announce");
		Message.infoColour = config.getConfigValueAsString("message.infoColour");
		Message.invalidPlayer = config.getConfigValueAsString("message.invalidPlayer");
		Message.consoleInvalidPlayer = config.getConfigValueAsString("message.consoleInvalidPlayer");
		Message.invalidAchievementID = config.getConfigValueAsString("message.invalidAchievementID");
		Message.invalidAchievement = config.getConfigValueAsString("message.invalidAchievement");
		Message.noAchievements = config.getConfigValueAsString("message.noAchievements");
		Message.achievementsListLine1 = config.getConfigValueAsString("message.achievementsListLine1");
		Message.achievementsListLine2 = config.getConfigValueAsString("message.achievementsListLine2");
		Message.achievementLookup = config.getConfigValueAsString("message.achievementLookup");
	}

	public static final class Message
	{
		public static String getAnnounce()
		{
			return announce;
		}

		public static String getInfoColour()
		{
			return infoColour;
		}

		public static String getInvalidPlayer()
		{
			return invalidPlayer;
		}

		public static String getConsoleInvalidPlayer()
		{
			return consoleInvalidPlayer;
		}

		public static String getInvalidAchievementID()
		{
			return invalidAchievementID;
		}

		public static String getInvalidAchievement()
		{
			return invalidAchievement;
		}

		public static String getNoAchievements()
		{
			return noAchievements;
		}

		public static String getAchievementsListLine1()
		{
			return achievementsListLine1;
		}

		public static String getAchievementsListLine2()
		{
			return achievementsListLine2;
		}

		public static String getAchievementLookup()
		{
			return achievementLookup;
		}

		private static String announce;
		private static String infoColour;
		private static String invalidPlayer;
		private static String consoleInvalidPlayer;
		private static String invalidAchievementID;
		private static String invalidAchievement;
		private static String noAchievements;
		private static String achievementsListLine1;
		private static String achievementsListLine2;
		private static String achievementLookup;
	}
}
