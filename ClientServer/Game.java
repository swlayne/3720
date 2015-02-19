import java.util.ArrayList;


public class Game {
	
	private String name;
	private int stardate;
	private ArrayList<ShipSpec> shiptypes = new ArrayList<ShipSpec> ();
	private ArrayList<WeaponSpec> weptypes =  new ArrayList<WeaponSpec> ();
	private ArrayList<Player> players = new ArrayList<Player> ();
	private ArrayList<Empire> empires = new ArrayList<Empire> ();
	private ArrayList<Base> bases = new ArrayList<Base> ();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStardate() {
		return stardate;
	}
	
	public void setStardate(int stardate) {
		this.stardate = stardate;
	}
	
	public ArrayList<ShipSpec> getShiptypes() {
		return shiptypes;
	}
	
	public void setShiptypes(ArrayList<ShipSpec> shiptypes) {
		this.shiptypes = shiptypes;
	}
	
	public ArrayList<WeaponSpec> getWeptypes() {
		return weptypes;
	}
	
	public void setWeptypes(ArrayList<WeaponSpec> weptypes) {
		this.weptypes = weptypes;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public ArrayList<Empire> getEmpires() {
		return empires;
	}
	
	public void setEmpires(ArrayList<Empire> empires) {
		this.empires = empires;
	}
	
	public ArrayList<Base> getBases() {
		return bases;
	}
	
	public void setBases(ArrayList<Base> bases) {
		this.bases = bases;
	}

	public void incrementStarDate() {
		stardate++;
	}

	public Player getPlayer(String Name) {
		for(int i = 0; i < players.size(); i++) {
		       if(Name.equals(players.get(i).getName()))
		       		return players.get(i);
		}
 		return null;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}	
}
