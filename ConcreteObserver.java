package shady_main;

public class ConcreteObserver implements Observer{
	
	ConcreteSubject subject;

	public ConcreteObserver(ConcreteSubject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public synchronized void update(Message m) {
		System.out.println(m);	
	}
	
	public void update() {
		System.out.println("no input arguments");
	}
	
	
}
