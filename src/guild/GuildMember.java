package guild;

import towns.Town;
import zombie.Zombie;

public class GuildMember
{

	private String memberName;
	private int rank;
	public GuildMember(String name, int rankR)
	{

		memberName = name;
		rank = rankR;
	}
	public int getRank()
	{
		return rank;
	}
	
	public String getName()
	{
		return memberName;
	}
	
	public Town killZombie(Zombie z, Town temp)
	{
		Town t = temp;
		t.update(z);
		return t;
	}

}
