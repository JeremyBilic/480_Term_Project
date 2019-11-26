package Client;

public class Client {

	public static void main(String[] args) {
		UserFrame uf = new RenterFrame();
		MainController controller = new MainController(uf);
		PRMSystem system = new PRMSystem();
		controller.setSystem(system);
		system.setController(controller);
		uf.setVisible(true);

	}

}
