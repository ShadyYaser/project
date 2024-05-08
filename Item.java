package shady_main;

public abstract class Item {
	String name;
	MainPlayer joel;
	
	Item(String name, MainPlayer joel){
		this.name = name;
		this.joel = joel;
	}
	
	public abstract void use();
	
	public final void makeItem() {
		acquire();
		prepare();
		complete();
	}
	
	public abstract void acquire();
	public void prepare() {
		UI.printNormal("Preparing " + this.name + " for use...");
	}
	public abstract void complete();
	
	public String getName() {
		return name;
	}
}
