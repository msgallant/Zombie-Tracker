package hordes;

import java.util.ArrayList;

import zombie.CountryComposite;
import zombie.Zombie;

public abstract class Horde extends CountryComposite {
	private String hordeID;
	private HordeType type;
	private int numZombies = 0;
	
	public Horde(String id, HordeType t)
	{
		hordeID = id;
		type = t;
	}
	public CountryComposite get(int index)
	{
		return this.getCountryComposite().get(index);
		
	}
	public String getHordeID()
	{
		return hordeID;
	}
	public HordeType getHordeType()
	{
		return type;
	}
	public void add(CountryComposite z)
	{
		
		super.add(z);
		numZombies += z.calculateAmountOfZombies();
	}
	//checking to see if the zombie is in the horde, if so, remove it from horde.
	public void remove(CountryComposite z)
	{
		ArrayList<CountryComposite> children = new ArrayList<>();
		children = this.getCountryComposite();
		for (int i =0; i < children.size(); i++)
		{
			if (children.get(i).equals(z))
			{
				super.remove(children.get(i));
				numZombies -= z.calculateAmountOfZombies();
			}
		}
				
	}
	public int calculateAmountOfZombies()
	{
		return numZombies;
	}
	//zombie z has been killed, check if it was in this horde, if so, remove it
	public void update(Zombie z)
	{
		remove(z);
	}

}
