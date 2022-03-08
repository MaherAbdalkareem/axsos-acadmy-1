
public class Gorila extends Mammal {
	
	public int totalEnergy=super.displayEnergy();
	
	public int throwSomething() {
		System.out.println("Gorila throw something , energy decrease by 5");
		int decrease = 0;
		decrease += 5;
		totalEnergy -=decrease;
		System.out.println(totalEnergy);
		return totalEnergy;
	}
	
	public int eatBananas() {
		System.out.println("Gorila eat banana , energy increase by 10");
		int increase =0;
		increase += 10;
		totalEnergy +=increase;
		System.out.println(totalEnergy);
		return totalEnergy;
	}
	
	public int climb() {
		System.out.println("Gorila climd , energy decrease by 10");
		int decrease = 0;
		decrease += 10;
		totalEnergy -=decrease;
		System.out.println(totalEnergy);
		return totalEnergy;
	}
	
}
