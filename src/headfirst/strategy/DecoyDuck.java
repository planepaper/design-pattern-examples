package headfirst.strategy;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
		eggBehavior = new SpawnNothing();
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
