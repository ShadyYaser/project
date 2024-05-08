package shady_main;

import java.util.ArrayList;

public class Hospital extends Location{
	
	public Hospital(MainPlayer joel){
		super(joel);
		this.name = "Hospital";
	}

	
	@Override
	public void next() {
		UI.printNormal("Last location in game!");
	}

	@Override
	public void printStatus() {
		UI.printNormal("You are at St. Mary's Hospital");
	}


	@Override
	public void description() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Item> getItems() {
		return items;
	}

	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}

}
