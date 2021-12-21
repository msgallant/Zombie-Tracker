package zombie;

public class Zombie extends CountryComposite {
	private int zombieID, numLimbs;
	
	public Zombie(int id, int limbs)
	{
		zombieID = id;
		numLimbs = limbs;
	}
	
	public int getZombieID()
	{
		return zombieID;
	}
	public int getNumLimbs()
	{
		return numLimbs;
	}

	public void setZombieID(int id)
	{
		zombieID = id;
	}
	public void setNumLimbs(int limbs)
	{
		numLimbs = limbs;
	}

	@Override
	public int calculateAmountOfZombies() {
		return 1;
	}

	@Override
	public CountryComposite get(int index) {
		return this;
	}
	//zombie z has been killed, if this was the zombie, remove it
	public void update(Zombie z)
	{
		
		if (z.equals(this))
		{
			remove(z);
		}
	}
	

}
