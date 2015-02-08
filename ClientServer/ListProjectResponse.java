import java.util.ArrayList;

public class ListProjectResponse extends ProjectResponse {
  
  public ArrayList<Project> projects;
  
  public ListProjectResponse(ArrayList<Project> projects) {
    this.projects = projects;
  }

}
