package Client;

import javax.swing.JFrame;

public class Client {

	public static void main(String[] args) {
		UserFrame uf = new RenterFrame();
		MainController controller = new MainController(uf);
		PRMSystem system = new PRMSystem();
		controller.setSystem(system);
		system.setController(controller);
		uf.setVisible(true);
		uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
