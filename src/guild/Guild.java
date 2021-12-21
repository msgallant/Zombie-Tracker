package guild;

import java.util.ArrayList;

public abstract class Guild {
	private String guildName;
	private ArrayList<GuildMember> members = new ArrayList<GuildMember>();
	public Guild (String name)
	{
		guildName = name;
	}

	public String getGuildName()
	{
		return guildName;
	}
	public ArrayList<GuildMember> getMembers()
	{
		return members;
	}
	public void add(GuildMember m)
	{
		members.add(m);
	}
	
	public void remove(GuildMember m)
	{
		for (int i =0; i < members.size(); i++)
		{
			if (members.get(i).equals(m))
			{
				members.remove(i);
			}
		}
	}


}
