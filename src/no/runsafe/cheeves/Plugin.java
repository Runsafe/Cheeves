package no.runsafe.cheeves;

import no.runsafe.cheeves.achievements.Pimp;
import no.runsafe.framework.RunsafePlugin;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Achievements
		this.addComponent(Pimp.class);
	}
}
