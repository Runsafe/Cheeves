package no.runsafe.cheeves;

import no.runsafe.cheeves.achivementtriggers.*;
import no.runsafe.cheeves.listeners.*;
import no.runsafe.cheeves.commands.AchievementLookup;
import no.runsafe.cheeves.commands.AwardAchievement;
import no.runsafe.cheeves.commands.ViewAchievements;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.features.Commands;
import no.runsafe.framework.features.Database;
import no.runsafe.framework.features.Events;

public class Cheeves extends RunsafeConfigurablePlugin
{
	@Override
	protected void pluginSetup()
	{
		// Framework features
		addComponent(Commands.class);
		addComponent(Events.class);
		addComponent(Database.class);

		// Plugin components
		addComponent(Config.class);
		addComponent(AchievementRepository.class);
		addComponent(AchievementHandler.class);
		addComponent(AchievementChecker.class);
		addComponent(ServerFirstHandler.class);

		// Configured listeners
		addComponent(AchievementDefinitionRepository.class);
		addComponent(ConfiguredAchievementTracker.class);

		// Achievements
		addComponent(Pimp.class);
		addComponent(EmeraldCity.class);
		addComponent(MyPrecious.class);
		addComponent(WizardHead.class);
		addComponent(Sponge.class);
		addComponent(Shieldwall.class);
		addComponent(Gladiator.class);
		addComponent(MercilessGladiator.class);
		addComponent(FleshWound.class);
		addComponent(KnuckleSandwich.class);
		addComponent(Cheerios.class);
		addComponent(WhatAreTheOdds.class);
		addComponent(LightningStrikesTwice.class);
		addComponent(SupremeArchitect.class);
		addComponent(IMadeThat.class);
		addComponent(Bullseye.class);
		addComponent(FlintsGoldHoarder.class);
		addComponent(MasterFisherman.class);
		addComponent(HuckleberryBeta.class);

		// Commands
		Command achievements = new Command("achievements", "Achievement related commands", null);
		achievements.addSubCommand(getInstance(AchievementLookup.class));
		achievements.addSubCommand(getInstance(ViewAchievements.class));
		addComponent(achievements);

		addComponent(AwardAchievement.class);
	}
}
