import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;

import com.google.gson.Gson;

public class ProjectServer extends NanoHTTPD {

  public ProjectServer(int port) {
    super(port);
  }

  @Override
  public synchronized Response serve(IHTTPSession session) {
    String path = session.getUri();
    String body = getBody(session);
    Object result;
    System.out.println("Incoming request: path = " + path + "; body: " + body);
    /*
    if (path.equals("/ListProjectRequest")) {
      ListProjectRequest request = new Gson().fromJson(body, ListProjectRequest.class);
      result = processListProjectRequest(request);
    } else if (path.equals("/AddIssueRequest")) {
        AddIssueRequest request = new Gson().fromJson(body, AddIssueRequest.class);
        result = processAddIssueRequest(request);
    } else if (path.equals("/EditIssueRequest")) {
        EditIssueRequest request = new Gson().fromJson(body, EditIssueRequest.class);
        result = processEditIssueRequest(request);
    } else if (path.equals("/DeleteIssueRequest")) {
        DeleteIssueRequest request = new Gson().fromJson(body, DeleteIssueRequest.class);
        result = processDeleteIssueRequest(request);
    } else */ if (path.equals("/TurnRequest")) {
        TurnRequest request = new Gson().fromJson(body, TurnRequest.class);
        result = processTurnRequest(request);
    } else if (path.equals("/RestoreGameRequest")) {
        RestoreGameRequest request = new Gson().fromJson(body, RestoreGameRequest.class);
        result = processRestoreGameRequest(request);
    } else {
        result = new ProjectResponse("Unimplemented request " + path);
    }
    
    String jsonResponse = new Gson().toJson(result);
    System.out.println("Sending response: " + jsonResponse);
    
    return new Response(jsonResponse);
  }

//Public only for Junit testing
public Object processRestoreGameRequest(RestoreGameRequest request) {
	ProjectDatabase.instance().restoreGameRequest(request.game);
	return null;
}

private Object processTurnRequest(TurnRequest request) {
	// TODO Auto-generated method stub
	return null;
}

/*
  private Object processEditIssueRequest(EditIssueRequest request) {
	ProjectDatabase.instance().editIssueRequest(request.m_projectNumber, request.m_issue);
	return null;
  }

  private Object processDeleteIssueRequest(DeleteIssueRequest request) {
	ProjectDatabase.instance().deleteIssueRequest(request.m_projectNumber, request.m_issue);
	return null;
  }

  private Object processAddIssueRequest(AddIssueRequest request) {
	ProjectDatabase.instance().addIssueRequest(request.m_projectNumber, request.m_issue);
	return null;
  }


  private Object processListProjectRequest(ListProjectRequest request) {
    ListProjectResponse response = new ListProjectResponse(
        ProjectDatabase.instance().getAll());
    
    return response;
  }
*/
  protected String getBody(IHTTPSession session) {
    int len = Integer.parseInt(session.getHeaders().get("content-length"));
    InputStream inputStream = session.getInputStream();

    try {
      byte[] buf = new byte[len];
      int bytesRead = 0;
      int read = 0;
      while (bytesRead < len && 
        (read = inputStream.read(buf, bytesRead, len - bytesRead)) > 0) {
          bytesRead += read;        
      }
      return new String(buf);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return "";
  }

  public static void main(String[] args) throws Throwable {
    ProjectServer server = new ProjectServer(8080);
    try {
      server.start();
    } catch (BindException ioe) {
      System.err.println("Couldn't start server: port is already in use (is another instance running?)");
      System.exit(-1);
    } catch (IOException ioe) {
      System.err.println("Couldn't start server:\n" + ioe);
      System.exit(-1);
    }
    
    System.out.println("Server started, Hit Enter to stop.\n");
    System.in.read();

    server.stop();
    System.out.println("Server stopped.\n");
  }
  
}
