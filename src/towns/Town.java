package towns;

import zombie.CountryComposite;
import zombie.Zombie;

public abstract class Town extends CountryComposite
{
	
	private String townName;
	public Town(String name)
	{
		townName = name;
	}
	public String getTownName()
	{
		return townName;
	}
	public abstract int calculateAmountOfZombies();
	public void update(Zombie z)
	{
		super.update(z);
	}
}
