import java.util.ArrayList;

public class ProjectDatabase {

  private static ProjectDatabase instance = new ProjectDatabase();
  private ArrayList<Game> games;
  
  private ProjectDatabase(){}
  
  public static ProjectDatabase instance() {
    return instance;
  }
  
  public ArrayList<Game> getAll() {
	    return games;
	  }
  
 /* public void addIssueRequest(int projectNum, String[] issue){
	  projects.get(projectNum).addIssue(Integer.parseInt(issue[0]), issue);
  }
  
  public void editIssueRequest(int projectNum, String[] issue){ 
	  projects.get(projectNum).removeIssue(Integer.parseInt(issue[0]));
	  projects.get(projectNum).addIssue(Integer.parseInt(issue[0]), issue);
  }
  
  public void deleteIssueRequest(int projectNum, String[] issue){
	  int index = Integer.parseInt(issue[0]);
	  projects.get(projectNum).removeIssue(Integer.parseInt(issue[0]));
	     for(int i = index; i < projects.get(projectNum).getNumberOfIssues(); i++) {
		 projects.get(projectNum).getIssue(i)[0] = Integer.toString(i);
	     }
  }
  */
  
  public void restoreGameRequest(String game){
	Game tmp = new Game();
	String[] gameLines = game.split("\n");
	 for (int x=0; x<gameLines.length; x++)
         System.out.println(gameLines[x]);
	
  }
  
}
