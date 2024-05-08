package shady_main;

public class Sarah implements NPC{
	
	String name;
	Location currentLocation;
	MainPlayer joel;
	private static Sarah instance;
	
	private Sarah(MainPlayer joel) {
		this.joel = joel;
		this.name = "Sarah";
		this.currentLocation = new JoelsHouse(joel);
	}
	
	public static synchronized Sarah getInstance(MainPlayer joel) {
		if(instance == null) 
			instance = new Sarah(joel);
			return instance;	
	}
	
	@Override
	public void talk() {
		UI.printNormal("Sarah:- Dad, I am in the kitchen!");
	}

}
