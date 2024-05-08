package shady_main;

import java.util.ArrayList;

public abstract class Location implements State{
	String name;
	String character;
	MainPlayer joel;
	ArrayList<Item> items = new ArrayList<Item>();
	
	Location(MainPlayer joel) {
	this.joel = joel;
	items.add(new GunItem("Gun", joel));
	items.add(new FlashlightItem("Flashlight", joel));
	items.add(new MedkitItem("Medkit", joel));
	}
	
	public synchronized String getLocName() {
		return name;
	}
	
	public abstract void description();
	public abstract ArrayList<Item> getItems();
	public abstract void next();
	public abstract void look();

}
