package shady_main;

public class ControlPanel {
	Command[] slots;
	
	public ControlPanel(Command[] slots) {
		this.slots = slots;
	}
	
	public void buttonWasPressed(int index) {
		slots[index].execute();
	}
	
	public synchronized void printCommands() {
		for(int i=0; i<slots.length; i++) {
			UI.printNormal(++i +". " + slots[i].getName());
		}
	}
}
