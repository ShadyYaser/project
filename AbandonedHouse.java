package shady_main;

import java.util.ArrayList;

public class AbandonedHouse extends Location{
	
	
	public AbandonedHouse(MainPlayer joel){
		super(joel);
		this.name = "Abandoned House";
	}

	
	@Override
	public void next() {
		joel.setLocation(new Hospital(joel));
	}

	@Override
	public void printStatus() {
		UI.printNormal("You are in an Abandoned House.");
	}


	@Override
	public void description() {
		UI.printNormal("2 weeks pass. Joel is wandering aimlessly still grieving, he feels tired and finds "
				+ " an abandoned house to rest in for the night.\n "
				+ "He finds, Ellie Williams, a 13 year old girl, sitting on the porch."
				+ " She shows Joel that she got bit by an infected 2 weeks ago and claims that she did not turn or experience"
				+ " any symptoms.\n She tells Joel that she is on a mission to St. Mary Hospital because she heard"
				+ " that there are doctors who can make a cure with immunity.\n She asks for his help to get there."
				+ "Joel, with a shocked expression, agrees to escort her safely to the hospital.");
		UI.printNormal("");
		UI.printNormal("Joel and Ellie enter the Abandoned House");
	}
	
	@Override
	public void look() {
		UI.printNormal("Joel looks around the house.\n"
				+ "He finds a flashlight and a medkit.");
	}
	
	
	@Override
	public ArrayList<Item> getItems() {
		return items;
	}

}
