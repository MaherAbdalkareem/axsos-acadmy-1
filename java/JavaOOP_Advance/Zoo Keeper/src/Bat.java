
public class Bat extends Mammal{
public int totalEnergy=super.displayEnergy()+200;
	
	public int fly() {
		System.out.println("Bat fly , energy decrease by 50");
		int decrease = 0;
		decrease += 50;
		totalEnergy -=decrease;
		System.out.println(totalEnergy);
		return totalEnergy;
	}
	
	public int eatHumans() {
		System.out.println("Bat eat human , energy increase by 25");
		int increase =0;
		increase += 25;
		totalEnergy +=increase;
		System.out.println(totalEnergy);
		return totalEnergy;
	}
	
	public int attackTown() {
		System.out.println("Bat attack town , energy decrease by 100");
		int decrease = 0;
		decrease += 100;
		totalEnergy -=decrease;
		System.out.println(totalEnergy);
		return totalEnergy;
	}
	
}
