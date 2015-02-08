import java.util.ArrayList;

public class ProjectDatabase {

  private static ProjectDatabase instance = new ProjectDatabase();
  private ArrayList<Project> projects;
  
  private ProjectDatabase(){
    String[] issue = {"0", "Issue for Project 1", "NEW", "Description for Issue of Project 1"};
    String[] issue2 = {"0", "Issue for Project 2", "NEW", "Description for Issue of Project 2"};
    String[] issue3 = {"0", "Issue for Project 3", "NEW", "Description for Issue of Project 3"};
	Project project = new Project("Project 1");
		project.addIssue(0, issue);
    Project project2 = new Project("Project 2");
		project2.addIssue(0, issue2);
    Project project3 = new Project("Project 3");
		project3.addIssue(0, issue3);
    
	projects = new ArrayList<Project> ();
	    projects.add(project);
	    projects.add(project2);
	    projects.add(project3);
  }
  
  public static ProjectDatabase instance() {
    return instance;
  }
  
  public ArrayList<Project> getAll() {
	    return projects;
	  }
  
  public void addIssueRequest(int projectNum, String[] issue){
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
}
