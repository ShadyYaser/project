package shady_main;

public class Doctor implements NPC{

	String name;
	Location currentLocation;
	MainPlayer joel;
	private static Doctor instance;
	
	private Doctor(MainPlayer joel) {
		this.joel = joel;
		this.name = "Doctor";
		this.currentLocation = new Hospital(joel);
	}
	
	public static synchronized Doctor getInstance(MainPlayer joel) {
		if(instance == null) 
			instance = new Doctor(joel);
			return instance;	
	}
	
	@Override
	public void talk() {
		UI.printNormal("Doctor:- Welcome to St. Mary's Hospital, how may I help?");//change
	}

}
