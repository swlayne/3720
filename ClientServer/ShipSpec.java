
public class ShipSpec {
	private String id;
	private String name;
	private String m_Class;
	private Empire emp;
	private int maxEnergy;
	private int maxShields;
	private int maxSpeed;
	private int maxMissile;
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

	public String getShipClass() {
		return m_Class;
	}

	public void setShipClass(String m_class) {
		m_Class = m_class;
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

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int speed) {
		maxSpeed = speed;
	}

	public int getMaxMissile() {
		return maxMissile;
	}

	public void setMaxMissile(int missile) {
		maxMissile = missile;
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
	
}
