public class MainDriver {
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame("Issue Tracking Application");
			frame.initServerConnection();
			frame.initFrame();
	}
}
