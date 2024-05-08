package shady_main;

import java.util.ArrayList;

public class JoelsHouse extends Location{
	
	
	public JoelsHouse(MainPlayer joel){
		super(joel);
		this.name = "Joels House";
	}
	
	
	
	@Override
	public void description() {
		UI.printNormal("You are in Joel's House. \n" + "You are watching a football match on TV on a quiet Saturday night, after putting "
				+ "Sarah to bed.\n" + "Suddenly, the TV channel switches to EMERGENCY NEWS.\n");
		UI.printNormal("Reporter:- The government issued a warning to stay indoors and barricade. "
				+ "I repeat stay indoors; DO NOT leave your house under any conditions");
	}



	@Override
	public ArrayList<Item> getItems() {
		return this.items; //return arraylist of items
	}


	@Override
	public void next() {
		joel.setLocation(new AbandonedHouse(joel));
		
	}


	@Override
	public void printStatus() {
		System.out.println("You are at Joel's House");
	}


	@Override
	public void look() {
		//do nothing, no need
	}



	
	
}
