
public class Ship {
	private ShipSpec specs;
	private int sX;
	private int sY;
	private int pX;
	private int pY;
	private int currEnergy;
	private int currMissiles;
	private int currShields;
	private String alert;
	
	public ShipSpec getSpecs() {
		return specs;
	}
	
	public void setSpecs(ShipSpec specs) {
		this.specs = specs;
	}

	public int getsX() {
		return sX;
	}

	public void setsX(int sX) {
		this.sX = sX;
	}

	public int getsY() {
		return sY;
	}

	public void setsY(int sY) {
		this.sY = sY;
	}

	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}

	public int getCurrEnergy() {
		return currEnergy;
	}

	public void setCurrEnergy(int currEnergy) {
		this.currEnergy = currEnergy;
	}

	public int getCurrMissiles() {
		return currMissiles;
	}

	public void setCurrMissiles(int currMissiles) {
		this.currMissiles = currMissiles;
	}

	public int getCurrShields() {
		return currShields;
	}

	public void setCurrShields(int currShields) {
		this.currShields = currShields;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}
	

}
