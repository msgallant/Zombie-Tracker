package hordes;

public class WeakHorde extends Horde{
	public WeakHorde(String id) {
		super(id, HordeType.WEAK);
	}

	@Override
	public int calculateAmountOfZombies() {
		return super.calculateAmountOfZombies();
	}
}
