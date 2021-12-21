package zombie;

import java.util.ArrayList;

import towns.Town;


public abstract class CountryComposite implements ZombieObserver {
	private ArrayList<CountryComposite> children = new ArrayList<>();
	
	public abstract CountryComposite get(int index);
	public void update(Zombie z, Town t)
	{
	
	}
	public void update(Zombie z)
	{
		for (int i =0; i< children.size(); i++)
		{
			if (children.get(i).getCountryComposite().size() != 0) //if not a solo zombie
			{
				children.get(i).update(z); //look through all zombies to see if the
				//zombie that died is among them and remove it.
			}
			else //if a solo zombie and is the one that died, remove it
			{
				if (children.get(i).equals(z))
				{
					children.remove(i);
				}
			}
		}
		
	}
	public void add(CountryComposite c)
	{
		children.add(c);
	}
	
	public void remove(CountryComposite c)
	{

		for (int i =0; i < children.size(); i++)
		{
			if (children.get(i).equals(c))
			{
				children.remove(i);
			}
		}
	}

	public ArrayList<CountryComposite> getCountryComposite()
	{
		return children;
	}
	public void setCountryComposite(ArrayList<CountryComposite> c)
	{
		children = c;
	}
	public abstract int calculateAmountOfZombies();
	
}
