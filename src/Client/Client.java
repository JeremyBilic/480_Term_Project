package Client;

public class Client {

	public static void main(String[] args) {
		UserFrame uf = new ManagerFrame();
		MainController controller = new MainController(uf);
		uf.setVisible(true);

	}

}
