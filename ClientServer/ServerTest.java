import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;


public class ServerTest {

	@Test
	public void test() throws FileNotFoundException {
		ProjectServer server = new ProjectServer(8080);
		RestoreGameRequest request = new RestoreGameRequest("Trek.dat");
		server.processRestoreGameRequest(request);
	}

}
