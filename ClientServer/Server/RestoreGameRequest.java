import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RestoreGameRequest extends ProjectRequest {
	
	public String game;
	
	public RestoreGameRequest(String filename) throws FileNotFoundException {
	String game = new Scanner(new File(filename)).useDelimiter("\\Z").next();
	}
	
public static void main(String[] args) throws FileNotFoundException{
	RestoreGameRequest request = new RestoreGameRequest("Trek.dat");
}
}