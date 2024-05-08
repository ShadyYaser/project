package shady_main;

import java.util.Scanner;

public class Console implements Runnable{
	
	Thread t;
	
	MainPlayer joel;
	
	Sarah sarah;
	Doctor doctor;
	Soldier soldier;
	Ellie ellie;
	Infected infected;
	
	Location currentLocation = new JoelsHouse(joel);
	
	GunItem gun = new GunItem("Gun", joel);
	MedkitItem medkit = new MedkitItem("Medkit", joel);
	FlashlightItem flashlight = new FlashlightItem("Flashlight", joel);
	
	ThreatenCommand threatencmd = new ThreatenCommand(joel);
	InteractCommand interactcmd = new InteractCommand(joel);
	Command[] cmds = {interactcmd, threatencmd};
	ControlPanel cmdsPanel = new ControlPanel(cmds);
	
	private static Console instance;

	private Console(){
		t = new Thread(this);
		t.start();
	}
	
	public static synchronized Console getInstance() {
		if(instance == null) 
			instance = new Console();
			return instance;	
	}
	
	public Thread getThread() {
		return t;
	}
	
	@Override
	public void run() {
		joel = MainPlayer.getInstance();
		sarah = Sarah.getInstance(joel);
		doctor = Doctor.getInstance(joel);
		soldier = Soldier.getInstance(joel);
		ellie = Ellie.getInstance(joel);
		infected = Infected.getInstance(joel);
		Scanner input = new Scanner(System.in);
		UI.printNormal("Enter start to begin game (exit to quit game): ");
		String userinput ="start";
		 if (input.hasNextLine())
             userinput = input.nextLine();
			if(userinput.equalsIgnoreCase("start")) {
				UI.printNormal("Welcome to Survivor's Echo\n" + "You are going to play as Joel Miller, father of"
						+ " 13 year old Sarah Miller.\n " +"Joel and Sarah live in Texas, in Joel's house.\n"
						+ "Joel is a hardworking carpenter, who lives to provide and take care of Sarah.");

				currentLocation.description();

				UI.printNormal("Joel goes to his room to fetch his gun for safety.");
				gun.makeItem();
				joel.printInventory();
				joel.talk();

				UI.printNormal("Rotate the phone landscape (left) to unlock main house door..");
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(joel.doorUnlocked) { //door unlocked using sensor
					UI.printNormal("Joel and Sarah head to the car/n"
							+ "They get into the car and start driving to leave town/nAs they are driving, "
							+ "they look around and the streets are full of mayhem and chaos filled with infected creatures chasing and "
							+ "biting civilians.\n"
							+ "A car crashes into them rendering their car useless\n"
							+ "Sarah can't walk so Joel has to carry her\n He finds a soldier and goes towards him asking for help");

					joel.seeSoldier = true;
					joel.talk();

					System.out.println("Swing the phone forward to shoot at Soldier..");
					try {
						Thread.sleep(10*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(joel.shotBack) {//shooting back at soldier using sensor
						UI.printNormal("Joel checks his body for gunshots but he hears his daughter faintly calling out his name. \n"
								+ "He runs to Sarah to find her laying on the ground with a gunshot to her chest.\n"
								+ "Joel cries for help but no one comes.\n"
								+ "He sits with his daughter's corpse in his hand.");

						currentLocation.next();//changing state to Scene 2: Abandoned House
						joel.setLocation(currentLocation);
					}
					else { //failed to shoot back
						UI.printNormal("Try again to shoot at Soldier!");
					}


				}
				else {//door not unlocked
					UI.printNormal("Try again to unlock the door!");
				}
				UI.printNormal("Enter continue to go to next location/scene: ");
				if (input.hasNextLine()) 
		            userinput = input.nextLine();
			}

			else if(userinput.equalsIgnoreCase("continue")) {
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentLocation.description();
				UI.printNormal("Enter look around to search the house: ");
				userinput = input.nextLine();
				if(userinput.equalsIgnoreCase("look around")) {
					currentLocation.look();
				}
				flashlight.makeItem();
				medkit.makeItem();
				joel.printInventory();
				try {
					Thread.sleep(3000);//simulate 3 seconds for infected to show up
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				UI.printNormal("Joel sees in an infected creature in the house.\n"
						+ "He pulls out his gun and shoots him in the head.\n"
						+ "Joel and Ellie continue to search for rooms to get some sleep in.");

				try {
					Thread.sleep(5000); //simulate 5 secs for swarm of infected to come due to gunshot sound
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				UI.printNormal("A swarm of infected came heard the gunshots and entered the house./n"
						+ "They are heading towards Ellie./n"
						+ "Choose what to do; act quickly!");
				
				joel.ellieNeedsHelp = true;
				joel.talk();
				
				UI.printNormal("1. Attack infected\n"
						+ "2. Evade infected");
				userinput = input.nextLine();
				if(userinput.contains("attack")) {
					joel.setStrategy(new AttackStrategy(joel)); //set strategy for joel, attack by default
					joel.combatStrategy(); //execute strategy
					
				}
				else if(userinput.contains("evade")) {
					joel.setStrategy(new EvadeStrategy(joel));
					joel.combatStrategy();
					
				}
				
				if(joel.getHealth() < 100) { //if joel takes damage
					UI.printNormal("Type heal to restore health");
					userinput = input.nextLine();
					if(userinput.equalsIgnoreCase("heal")) {
						joel.useItem("Medkit");
					}
				}
				UI.printNormal("Joel and Ellie escape the house safely. They find an abandoned horse and use it to get \n"
						+ "to St. Mary Hospital.");
				
				currentLocation.next();//changing state to Scene 3: Hospital
				joel.setLocation(currentLocation);
				UI.printNormal("Enter final to go to final location/scene: ");
				if (input.hasNextLine()) 
		            userinput = input.nextLine();
			}

			else if(userinput.equalsIgnoreCase("final")) {
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				UI.printNormal("You and Ellie arrive at the hospital.");
				
				UI.printNormal("Speak into the phone to call out the doctors.");
				
				if(joel.DoctorsFound) {
					joel.talk();
					
					UI.printNormal("Choose what to do next (type first or second): ");
					cmdsPanel.printCommands();
					
					userinput = input.nextLine();
					if(userinput.equalsIgnoreCase("first")) {
						cmdsPanel.buttonWasPressed(0);
					}
					else if(userinput.equalsIgnoreCase("second")){
						cmdsPanel.buttonWasPressed(1);
					}
					else {
						UI.printNormal("No such choice exists!.");
					}
					
					try {
						Thread.sleep(10*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					joel.finishedGame = true;
					UI.printNormal("Doctor made a cure in 2 hours!\n"
							+ "THE END\n");
					input.close();
					UI.printNormal("Enter exit: ");
					if (input.hasNextLine()) 
			            userinput = input.nextLine();
				}
			}
	}
}
