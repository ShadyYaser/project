package shady_main;

public class Ellie implements NPC{
	
	String name;
	Location currentLocation;
	MainPlayer joel;
	private static Ellie instance;
	
	private Ellie(MainPlayer joel) {
		this.joel = joel; 
		this.name = "Ellie";
		this.currentLocation = new AbandonedHouse(joel); //initial loc
	}

	public static synchronized Ellie getInstance(MainPlayer joel) {
		if(instance == null) 
			instance = new Ellie(joel);
			return instance;	
	}
	
	@Override
	public void talk() {
		System.out.println("Ellie:- Joel, help me!");
	}
	
	public void setLocation(Location location) {
		this.currentLocation = location;
	}

 
}
