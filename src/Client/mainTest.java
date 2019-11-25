package Client;

public class mainTest
{
	public static void main(String[] args)
	{
		//System.out.println("test");
		//RenterFrame frame = new RenterFrame();
		//RegisteredRenterFrame frame = new RegisteredRenterFrame();
		LandlordFrame frame = new LandlordFrame();
		//ManagerFrame frame = new ManagerFrame();
		MainController controller = new MainController(frame);
		frame.setVisible(true);
	}
}
