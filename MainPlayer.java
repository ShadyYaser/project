package shady_main;

import java.util.ArrayList;
import java.util.Random;

public class MainPlayer extends Character implements Runnable{

	ArrayList<Item> items = new ArrayList<Item>();
	
	boolean FoundSarah=false;
	boolean finishedGame = false;
	boolean seeSoldier = false;
	boolean soldierShotGun = false;
	boolean shotBack = false;
	boolean DoctorsFound = false;
	boolean ellieNeedsHelp = false;
	boolean doorUnlocked = false;
	
	private static MainPlayer instance; //singelton
	Sarah sarah;
	Doctor doctor;
	Soldier soldier;
	Ellie ellie;
	Infected infected;
	
	CombatStrategy strategy;//initial strategy
	
	Thread t;
	
	
	private MainPlayer() {
		super("Joel", new AbandonedHouse(instance));
		t = new Thread(this);
		t.start();
	}
	
	public static synchronized MainPlayer getInstance() {
		if(instance == null) { 
        	instance = new MainPlayer(); 
        	return instance;
		}
		else
			return instance;	
	}
	
	public synchronized void setStrategy(CombatStrategy strategy) {
		this.strategy = strategy;
	}
	
	public synchronized void combatStrategy() {
		strategy.action();
	}
	
	@Override
	public synchronized void update(Message m) {
		if(m.topic == "landscape") {
			if(m.payload.equalsIgnoreCase("yes")) {
				doorUnlocked = true;
			}
		}
		else if(m.topic == "speaking") {
			if(m.payload.equalsIgnoreCase("yes")) {
				DoctorsFound = true;
			}
		}
		else if(m.topic == "shoot") {
			if(m.payload.equalsIgnoreCase("yes")) {
				shotBack = true;
				useItem("Gun");
			}
		}
	}
	
	public void printInventory() {
		System.out.println("Joel's inventory of items: ");
		for(int i=0; i<items.size(); i++) {
			String item = items.get(i).getName();
			System.out.println(++i + ". " +item);
		}
	}
	
	public synchronized void talk() {
		if(currentLocation.getLocName().equalsIgnoreCase("Joels House")){
			UI.printNormal("Joel:- Sarah where are you?");
			if(FoundSarah) {
				callforSarah();
				UI.printNormal("Joel:- We need to leave, it seems like something big is happening. "
						+ "Pack your things and get in the car");
				FoundSarah = false;
			}
			if(seeSoldier) {
				UI.printNormal("Joel:- Hey, Solider! We need help over here.");
				soldier.talk();
				seeSoldier = false;
			}
		}
		else if(currentLocation.getLocName().equalsIgnoreCase("Abandoned House")) {
			
			if(ellieNeedsHelp) {
				UI.printNormal("Joel:- ELLIE! Run!");
				ellie.talk();
			}
		}
		else if(currentLocation.getLocName().equalsIgnoreCase("Hospital")) {
			UI.printNormal("Joel:- Hello, Doctor. It has been a long journey.");
			doctor.talk();
		}
	}
	
	public synchronized void callforSarah() {
		sarah.talk();
	}
	
	public synchronized void useItem(String item) {
		if(currentLocation.getLocName().equalsIgnoreCase("Joels House")) {
			UI.printNormal("Joel uses his gun to shoot the solider."); 
		}
		else if(currentLocation.getLocName().equalsIgnoreCase("Abandoned House")) {
			if(item.equalsIgnoreCase("Gun")) {
				UI.printNormal("Joel uses his gun to shoot the infected");
				Random random = new Random();
				int randomno = random.nextInt(2);
				if(randomno == 0) {
					System.out.println("You have killed the infected. Good job!");
				}
				else if(randomno==1) {
					UI.printNormal("You missed... Joel suffers injury from attack and escapes.");
					this.health -= 25;
					if(health<0) this.health = 100; //respawn
					UI.printNormal("Health: " + this.health);
				}
			}
			else if (item.equalsIgnoreCase("Medkit")) {
				if(this.health <= 75) {UI.printNormal("Joel uses his "+ item + " to heal");
				this.health = 100;
				removeMedkit();
				}
				else {
					UI.printNormal("Joel's health is above 50%, can't use Medkit");
				}
			}
			else if(item.equalsIgnoreCase("Flashlight")) {
				UI.printNormal("Joel uses the flashlight to see");
			}
		}
	}
	
	public synchronized void setLocation(Location location) {
		this.currentLocation = location;
		if(currentLocation.getLocName().equalsIgnoreCase("Hospital")) {
			ellie.setLocation(new Hospital(instance));
		}
		
	}
	
	public void removeMedkit() {
		for(int i=0; i<items.size(); i++) {
			Item item = items.get(i);
			if(item.getName().equalsIgnoreCase("medkit")) {
				items.remove(i);
			}
		}
	}
	
	@Override
	public void run() {
		sarah  = Sarah.getInstance(instance);
		doctor = Doctor.getInstance(instance);
		soldier  = Soldier.getInstance(instance);
		ellie  = Ellie.getInstance(instance);
		infected  = Infected.getInstance(instance);
		strategy  = new AttackStrategy(instance); 
		while(!finishedGame) {
			
			try {
				Thread.sleep(5000); //simulate 5 secs to find sarah
				FoundSarah = true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				if(this.seeSoldier) {
					soldier.talk();
					this.seeSoldier = false;
				}
			
			
		}
	}

	public synchronized void threatenDoc() {
		UI.printNormal("You raise your gun at the doctor and force him to make a cure!!");
		this.finishedGame = true;
	}

	public  synchronized void askDocNicely() {
		UI.printNormal("You ask the doctor politely to make a cure.\n"
				+ "Doctor agrees.");
		this.finishedGame = true;
	}
	
	public Thread getThread() {
		return t;
	}
}
