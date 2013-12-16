package no.runsafe.cheeves;

import no.runsafe.cheeves.achievements.*;
import no.runsafe.cheeves.commands.AchievementLookup;
import no.runsafe.cheeves.commands.AwardAchievement;
import no.runsafe.cheeves.commands.ViewAchievements;
import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.features.Commands;
import no.runsafe.framework.features.Database;
import no.runsafe.framework.features.Events;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void pluginSetup()
	{
		// Framework features
		addComponent(Commands.class);
		addComponent(Events.class);
		addComponent(Database.class);

		// Plugin components
		this.addComponent(AchievementRepository.class);
		this.addComponent(AchievementHandler.class);
		this.addComponent(AchievementChecker.class);
		this.addComponent(ServerFirstHandler.class);

		// Achievements
		this.addComponent(Pimp.class);
		this.addComponent(EmeraldCity.class);
		this.addComponent(DefenseOfTheKingdom.class);
		this.addComponent(MyPrecious.class);
		this.addComponent(PvPTournamentJune.class);
		this.addComponent(ServerFirstEnderDragon.class);
		this.addComponent(TheTunnel.class);
		this.addComponent(WizardHead.class);
		this.addComponent(Sponge.class);
		this.addComponent(WickedSick.class);
		this.addComponent(Shieldwall.class);
		this.addComponent(Gladiator.class);
		this.addComponent(MercilessGladiator.class);
		this.addComponent(FleshWound.class);
		this.addComponent(KnuckleSandwich.class);
		this.addComponent(Cheerios.class);
		this.addComponent(WhatAreTheOdds.class);
		this.addComponent(SewageSurvivor.class);
		this.addComponent(LightningStrikesTwice.class);
		this.addComponent(SupremeArchitect.class);
		this.addComponent(IMadeThat.class);
		this.addComponent(MyBrainHurts.class);
		this.addComponent(ServerFirstMyBrainHurts.class);
		this.addComponent(VaultDweller.class);
		this.addComponent(SpleefTournamentAugust.class);
		this.addComponent(SpleefTournamentAugustWinner.class);
		this.addComponent(SurvivalChallenge.class);
		this.addComponent(SurvivalChallengeWinner.class);

		this.addComponent(AchievementFinder.class);

		// Commands
		Command achievements = new Command("achievements", "Achievement related commands", null);
		achievements.addSubCommand(getInstance(AchievementLookup.class));
		achievements.addSubCommand(getInstance(ViewAchievements.class));
		this.addComponent(achievements);

		this.addComponent(AwardAchievement.class);
	}
}
