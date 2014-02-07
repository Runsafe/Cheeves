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

public class Cheeves extends RunsafePlugin
{
	@Override
	protected void pluginSetup()
	{
		// Framework features
		addComponent(Commands.class);
		addComponent(Events.class);
		addComponent(Database.class);

		// Plugin components
		addComponent(AchievementRepository.class);
		addComponent(AchievementHandler.class);
		addComponent(AchievementChecker.class);
		addComponent(ServerFirstHandler.class);

		// Achievements
		addComponent(Pimp.class);
		addComponent(EmeraldCity.class);
		addComponent(DefenseOfTheKingdom.class);
		addComponent(MyPrecious.class);
		addComponent(PvPTournamentJune.class);
		addComponent(ServerFirstEnderDragon.class);
		addComponent(TheTunnel.class);
		addComponent(WizardHead.class);
		addComponent(Sponge.class);
		addComponent(WickedSick.class);
		addComponent(Shieldwall.class);
		addComponent(Gladiator.class);
		addComponent(MercilessGladiator.class);
		addComponent(FleshWound.class);
		addComponent(KnuckleSandwich.class);
		addComponent(Cheerios.class);
		addComponent(WhatAreTheOdds.class);
		addComponent(SewageSurvivor.class);
		addComponent(LightningStrikesTwice.class);
		addComponent(SupremeArchitect.class);
		addComponent(IMadeThat.class);
		addComponent(MyBrainHurts.class);
		addComponent(ServerFirstMyBrainHurts.class);
		addComponent(VaultDweller.class);
		addComponent(SpleefTournamentAugust.class);
		addComponent(SpleefTournamentAugustWinner.class);
		addComponent(SurvivalChallenge.class);
		addComponent(SurvivalChallengeWinner.class);
		addComponent(MasterOfMagic.class);
		addComponent(ApprenticeWizard.class);
		addComponent(TouchOfDeath.class);
		addComponent(TunnelStage1.class);
		addComponent(TunnelStage2.class);
		addComponent(TunnelStage3.class);
		addComponent(TunnelStage4.class);
		addComponent(TunnelStage5.class);
		addComponent(SomebodyLikesMe.class);
		addComponent(Backstabber.class);

		addComponent(AchievementFinder.class);

		// Commands
		Command achievements = new Command("achievements", "Achievement related commands", null);
		achievements.addSubCommand(getInstance(AchievementLookup.class));
		achievements.addSubCommand(getInstance(ViewAchievements.class));
		addComponent(achievements);

		addComponent(AwardAchievement.class);
	}
}
