package Client;

public class Client {

	public static void main(String[] args) {
		UserFrame uf = new LandlordFrame();
		MainController controller = new MainController(uf);
		uf.setVisible(true);

	}

}
