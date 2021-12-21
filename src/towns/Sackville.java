package towns;

import java.util.ArrayList;

import zombie.CountryComposite;

public class Sackville extends Town {

	public Sackville() {
		super("Sackville");

	}

	@Override
	public int calculateAmountOfZombies() {
		int numZombies = 0;
		ArrayList<CountryComposite> children = super.getCountryComposite();
		for (int i = 0; i < children.size(); i++)
		{
			numZombies += children.get(i).calculateAmountOfZombies();
		}
		return numZombies;
	}

	@Override
	public CountryComposite get( int index) {
		if (this.getCountryComposite().size() <= index && index > -1)
		{
			return this.getCountryComposite().get(index);
		}
		return null;
	}

}
