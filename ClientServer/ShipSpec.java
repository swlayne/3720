
public class ShipSpec {
	private String id;
	private String name;
	private Empire emp;
	private int maxEnergy;
	private int maxShields;
	private WeaponSpec energyWep;
	private WeaponSpec missileWep;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Empire getEmp() {
		return emp;
	}

	public void setEmp(Empire emp) {
		this.emp = emp;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public int getMaxShields() {
		return maxShields;
	}

	public void setMaxShields(int maxShields) {
		this.maxShields = maxShields;
	}

	public WeaponSpec getEnergyWep() {
		return energyWep;
	}

	public void setEnergyWep(WeaponSpec energyWep) {
		this.energyWep = energyWep;
	}

	public WeaponSpec getMissileWep() {
		return missileWep;
	}

	public void setMissileWep(WeaponSpec missileWep) {
		this.missileWep = missileWep;
	}

	public static Object init(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
