package shady_main;

public class Infected implements NPC{

	String name;
	Location currentLocation;
	MainPlayer joel;
	private static Infected instance;
	
	
	private Infected(MainPlayer joel) {
		this.joel = joel;
		this.name = "Infected";
		this.currentLocation = new AbandonedHouse(joel); //only loc
	}
	
	public static synchronized Infected getInstance(MainPlayer joel) {
		if(instance == null) 
			instance = new Infected(joel);
			return instance;	
	}
	

	@Override
	public void talk() {
		//dont talk
	}
	
}
