package test;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import guild.Guild;
import guild.GuildMember;
import guild.SackvilleGuild;
import hordes.Horde;
import hordes.HordeType;
import hordes.ModerateHorde;
import hordes.StrongHorde;
import hordes.WeakHorde;
import towns.Sackville;
import towns.Town;
import zombie.Zombie;

class ZombieTrackerTest {

	@Test
	void test() {
		Zombie z1 = new Zombie(1, 4);
		Zombie z2 = new Zombie(2, 3);
		Zombie z3 = new Zombie(3, 2);
		Zombie z4 = new Zombie(4, 4);
		Zombie z5 = new Zombie(5, 4);
		Zombie z6 = new Zombie(6, 4);
		Zombie z7 = new Zombie(7, 4);
		Zombie z8 = new Zombie(8, 4);
		Zombie z9 = new Zombie(9, 4);
		Zombie z10 = new Zombie(10, 1);
		

		
		//testing zombie ID
		assertThat(z1.getZombieID()).isEqualTo(1);
		assertThat(z2.getZombieID()).isEqualTo(2);
		
		//testing number of zombie limbs
		assertThat(z1.getNumLimbs()).isEqualTo(4);
		assertThat(z2.getNumLimbs()).isEqualTo(3);
		assertThat(z3.getNumLimbs()).isEqualTo(2);
		
		Horde h1 = new WeakHorde("#1");
		Horde h2 = new ModerateHorde("#2");
		Horde h3 = new StrongHorde("#3");
		
		//testing horde IDs
		assertThat(h1.getHordeID()).isEqualTo("#1");
		assertThat(h2.getHordeID()).isEqualTo("#2");
		assertThat(h3.getHordeID()).isEqualTo("#3");
		
		//testing amount of zombies in different hordes 
		h1.add(z1);
		h1.add(z2);
		h1.add(z10); //3 zombies in h1
		assertThat(h1.calculateAmountOfZombies()).isEqualTo(3);
		
		h1.remove(z2); //2 zombies in h1
		assertThat(h1.calculateAmountOfZombies()).isEqualTo(2);
		
		
		
		h2.add(z2);
		h2.add(z5);
		h2.add(z6); //3 zombies in h2
		assertThat(h2.calculateAmountOfZombies()).isEqualTo(3);
		
		h3.add(z7);
		h3.add(z8);
		h3.add(z9); //4 zombies in h3
		h3.add(z3);
		assertThat(h3.calculateAmountOfZombies()).isEqualTo(4);
		
		//testing horde types
		assertThat(h1.getHordeType()).isEqualTo(HordeType.WEAK);
		assertThat(h2.getHordeType()).isEqualTo(HordeType.MODERATE);
		assertThat(h3.getHordeType()).isEqualTo(HordeType.STRONG);
		
		Guild sackvilleGuild = new SackvilleGuild();
		
		//testing amount of zombies in multiple hordes or alone in a town, sackville.
		Town sackville = new Sackville();
		
		sackville.add(h1); //2 zombies in h1
		assertThat(sackville.calculateAmountOfZombies()).isEqualTo(2);
		
		sackville.add(h2); // 3 zombies
		sackville.add(h3); // 4 zombies
		sackville.add(z4); //1 zombie
		//plus 2 zombies already in h1, therefore, 10 zombies in sackville
		assertThat(sackville.calculateAmountOfZombies()).isEqualTo(10);
		
		GuildMember g1 = new GuildMember("Alice", 7);
		GuildMember g2 = new GuildMember("Blair", 10);
		GuildMember g3 = new GuildMember("Christian", 8);
		
		
		Guild sackvilleZombieHunters = new SackvilleGuild();
		sackvilleZombieHunters.add(g1);
		sackvilleZombieHunters.add(g2);
		sackvilleZombieHunters.add(g3);
		
		//testing guild name
		assertThat(sackvilleZombieHunters.getGuildName()).isEqualTo("Sackville Zombie Hunters");
		
		//testing that all members are successfully stored in the guild
		assertThat(sackvilleZombieHunters.getMembers().get(0)).isEqualTo(g1);
		assertThat(sackvilleZombieHunters.getMembers().get(1)).isEqualTo(g2);
		assertThat(sackvilleZombieHunters.getMembers().get(2)).isEqualTo(g3);
		
		//testing if amount of zombies is correctly calculated after a 
		//hunter kills one
		
		sackville = g2.killZombie(z6, sackville);
		assertThat(sackville.calculateAmountOfZombies()).isEqualTo(9);
		
		sackville = g1.killZombie(z4, sackville);
		
		assertThat(sackville.calculateAmountOfZombies()).isEqualTo(8);
		
		sackville = g3.killZombie(z10, sackville);
		sackville = g2.killZombie(z9, sackville);
		assertThat(sackville.calculateAmountOfZombies()).isEqualTo(6);

	}

}
