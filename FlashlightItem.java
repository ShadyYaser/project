package shady_main;

public class FlashlightItem extends Item{
	
	
	FlashlightItem(String name, MainPlayer joel) {
		super(name, joel);
	}

	@Override
	public void use() {
		joel.useItem(name);
		UI.printNormal("I can see now.. *sigh*");
	}

	@Override
	public void acquire() {
		UI.printNormal("Identified Flashlight.. acquiring it");
	}

	@Override
	public void complete() {
		UI.printNormal("Flashlight is ready for use.");
	}

}
