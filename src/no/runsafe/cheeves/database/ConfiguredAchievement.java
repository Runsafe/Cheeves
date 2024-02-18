package no.runsafe.cheeves.database;

import no.runsafe.cheeves.IAchievement;

public class ConfiguredAchievement implements IAchievement
{
	public ConfiguredAchievement(int id, String name, String info, String triggerEvent, Boolean serverFirst)
	{
		this.name = name;
		this.info = info;
		this.id = id;
		this.triggerEvent = triggerEvent;
		this.serverFirst = serverFirst;
	}

	@Override
	public String getAchievementName()
	{
		return name;
	}

	@Override
	public String getAchievementInfo()
	{
		return info;
	}

	@Override
	public int getAchievementID()
	{
		return id;
	}

	@Override
	public String getTriggerEvent()
	{
		return triggerEvent;
	}

	@Override
	public Boolean getServerFirst()
	{
		return serverFirst;
	}

	private final String name;
	private final String info;
	private final int id;
	private final String triggerEvent;
	private final Boolean serverFirst;
}
