package shady_main;

public abstract class Character extends ConcreteObserver {
	Location currentLocation;
	String name;
	int health;
	
	Character(String name, Location currentLocation){
		super(TCP_Client.getInstance());
		this.name = name;
		this.currentLocation = currentLocation;
		this.health = 100;
	}
	

	public abstract void talk();
	public String getName() {
		return name;
	}
	public String getPlayerLocName() {
		return currentLocation.getLocName();
	}
	public int getHealth() {
		return health;
	}
	
}
