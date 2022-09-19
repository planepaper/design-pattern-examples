package headfirst.strategy;

public class MiniDuckSimulator {
 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		RubberDuck	rubberDuckie = new RubberDuck();
		DecoyDuck	decoy = new DecoyDuck();
 
		ModelDuck	model = new ModelDuck();

		mallard.performQuack();
		rubberDuckie.performQuack();
		decoy.performQuack();
   
		model.performFly();	
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		System.out.println();
		System.out.println("DoubleQuack test");
		model.performQuack();

		System.out.println();
		System.out.println("BadDuck Behavior test");
		BadDuck bad = new BadDuck();
		bad.performQuack();
		bad.performQuack();
		bad.performQuack();
		bad.performFly();

		System.out.println();
		System.out.println("EggBehavior Test");
		Duck ducks[] = {mallard, rubberDuckie, decoy, model};
		for (Duck duck : ducks) {
			duck.display();
			duck.performEgg();
		}

		System.out.println();
		System.out.println("Change Mallard EggBehavior");
		mallard.setEggBehavior(new SpawnEgg());
		for (Duck duck : ducks) {
			duck.display();
			duck.performEgg();
		}

		System.out.println();
		System.out.println("CopyBehavior Test");
		model.display();
		model.performEgg();
		System.out.println();

		System.out.println("Copy Mallard to Model");
		model.CopyBehavior(mallard);
		model.display();
		model.performEgg();
	}
}
