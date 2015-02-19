import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataStore {

	private ArrayList<Game> m_games = new ArrayList<Game> ();
	private ArrayList<String> m_restoredGames = new ArrayList<String> ();
	private static DataStore m_dataStore = new DataStore();
	private static final String m_IPAddress = "http://localhost:8080/";
	private static String m_CreatorID = "Taylor";
	private static Player m_CurrentUser;
	private static int m_port;
	private GameListTable m_GameListTable;
	
	public static DataStore getDataStore() {
		return m_dataStore;
	}
	
	public void setGameListTable(GameListTable gameListTable) {
		m_GameListTable = gameListTable;
	}
	
	public void setCreatorID(String creatorID) {
		m_CreatorID = creatorID;
	}
	
	public void setCurrentUser(Player CurrentUser) {
		m_CurrentUser = CurrentUser;
	}
	
	public void setPort(int port) {
		m_port = port;
	}
	
	public String getCreatorID() {
		return m_CreatorID;
	}
	
	public Player getCurrentUser() {
		return m_CurrentUser;
	}
	
	public Game getGame(int pos) {
		return m_games.get(pos);
	}
	
	public ArrayList<Game> getGameList() {
		return m_games;
	}
	
	public int getGameListLength() {
		return m_games.size();
	}
	
	public void addGame(Game game) {
		m_games.add(game);
		m_GameListTable.addGame(game);
	}
	
	public void restoreGame(String fileName) {
		for(int i = 0; i < m_restoredGames.size(); i++) {
			if(m_restoredGames.get(i).equals(fileName)) {
				JOptionPane.showMessageDialog(null, "This game is already in progress.");
				return;
			}
		}
		Game trek = new Game();
			trek.setName("Star Trek Forever");
			trek.setStardate(2236);
				Empire Federation = new Empire();
				Federation.setId("1000");
				Federation.setName("FEDERATION");
				Federation.setMission("EXPLORATION");
			WeaponSpec engWep = new WeaponSpec();
				engWep.setId("1");
				engWep.setYield(10);
				engWep.setName("Laser");
				engWep.setType("ENGERY");
			WeaponSpec misWep = new WeaponSpec();
				misWep.setId("2");
				misWep.setYield(30);
				misWep.setName("Torpedo");
				misWep.setType("MISSILE");
			ShipSpec shipspecs = new ShipSpec();
				shipspecs.setId("1000");
				shipspecs.setShipClass("STARSHIP");
				shipspecs.setEmp(Federation);
				shipspecs.setName("Taylor's Ship");
				shipspecs.setEnergyWep(engWep);
				shipspecs.setMaxEnergy(1200);
				shipspecs.setMaxMissile(100);
				shipspecs.setMaxShields(1000);
				shipspecs.setMaxSpeed(10000);
				shipspecs.setMissileWep(misWep);
			Ship ship = new Ship();
				ship.setsX(1);
				ship.setsY(1);
				ship.setpX(2);
				ship.setpY(2);
				ship.setCurrShields(800);
				ship.setCurrEnergy(500);
				ship.setAlert("GREEN");
				ship.setCurrMissiles(50);
				ship.setSpecs(shipspecs);
			Player player = new Player();
				player.setName("Taylor");
				player.setEmp(Federation);
				player.setS(ship);
		setCurrentUser(player);
		trek.addPlayer(player);
				Federation = new Empire();
				Federation.setId("1000");
				Federation.setName("FEDERATION");
				Federation.setMission("EXPLORATION");
			engWep = new WeaponSpec();
				engWep.setId("1");
				engWep.setYield(10);
				engWep.setName("Laser");
				engWep.setType("ENGERY");
			misWep = new WeaponSpec();
				misWep.setId("2");
				misWep.setYield(30);
				misWep.setName("Torpedo");
				misWep.setType("MISSILE");
			shipspecs = new ShipSpec();
				shipspecs.setId("1000");
				shipspecs.setShipClass("STARSHIP");
				shipspecs.setEmp(Federation);
				shipspecs.setName("Nick's Ship");
				shipspecs.setEnergyWep(engWep);
				shipspecs.setMaxEnergy(1200);
				shipspecs.setMaxMissile(100);
				shipspecs.setMaxShields(1000);
				shipspecs.setMaxSpeed(10000);
				shipspecs.setMissileWep(misWep);
			ship = new Ship();
				ship.setsX(1);
				ship.setsY(1);
				ship.setpX(2);
				ship.setpY(2);
				ship.setCurrShields(800);
				ship.setCurrEnergy(500);
				ship.setAlert("GREEN");
				ship.setCurrMissiles(50);
				ship.setSpecs(shipspecs);
			player = new Player();
				player.setName("Nick");
				player.setEmp(Federation);
				player.setS(ship);
		trek.addPlayer(player);
				Federation = new Empire();
				Federation.setId("1000");
				Federation.setName("FEDERATION");
				Federation.setMission("EXPLORATION");
			engWep = new WeaponSpec();
				engWep.setId("1");
				engWep.setYield(10);
				engWep.setName("Laser");
				engWep.setType("ENGERY");
			misWep = new WeaponSpec();
				misWep.setId("2");
				misWep.setYield(30);
				misWep.setName("Torpedo");
				misWep.setType("MISSILE");
			shipspecs = new ShipSpec();
				shipspecs.setId("1000");
				shipspecs.setShipClass("STARSHIP");
				shipspecs.setEmp(Federation);
				shipspecs.setName("Conner's Ship");
				shipspecs.setEnergyWep(engWep);
				shipspecs.setMaxEnergy(1200);
				shipspecs.setMaxMissile(100);
				shipspecs.setMaxShields(1000);
				shipspecs.setMaxSpeed(10000);
				shipspecs.setMissileWep(misWep);
			ship = new Ship();
				ship.setsX(1);
				ship.setsY(1);
				ship.setpX(2);
				ship.setpY(2);
				ship.setCurrShields(800);
				ship.setCurrEnergy(500);
				ship.setAlert("GREEN");
				ship.setCurrMissiles(50);
				ship.setSpecs(shipspecs);
			player = new Player();
				player.setName("Conner");
				player.setEmp(Federation);
				player.setS(ship);
		trek.addPlayer(player);
				Federation = new Empire();
				Federation.setId("1000");
				Federation.setName("FEDERATION");
				Federation.setMission("EXPLORATION");
			engWep = new WeaponSpec();
				engWep.setId("1");
				engWep.setYield(10);
				engWep.setName("Laser");
				engWep.setType("ENGERY");
			misWep = new WeaponSpec();
				misWep.setId("2");
				misWep.setYield(30);
				misWep.setName("Torpedo");
				misWep.setType("MISSILE");
			shipspecs = new ShipSpec();
				shipspecs.setId("1000");
				shipspecs.setShipClass("STARSHIP");
				shipspecs.setEmp(Federation);
				shipspecs.setName("Rayne's Ship");
				shipspecs.setEnergyWep(engWep);
				shipspecs.setMaxEnergy(1200);
				shipspecs.setMaxMissile(100);
				shipspecs.setMaxShields(1000);
				shipspecs.setMaxSpeed(10000);
				shipspecs.setMissileWep(misWep);
			ship = new Ship();
				ship.setsX(1);
				ship.setsY(1);
				ship.setpX(2);
				ship.setpY(2);
				ship.setCurrShields(800);
				ship.setCurrEnergy(500);
				ship.setAlert("GREEN");
				ship.setCurrMissiles(50);
				ship.setSpecs(shipspecs);
			player = new Player();
				player.setName("Rayne");
				player.setEmp(Federation);
				player.setS(ship);
		trek.addPlayer(player);
		
		m_games.add(trek);
		m_GameListTable.addGame(trek);
		m_restoredGames.add(fileName);
	}
}
