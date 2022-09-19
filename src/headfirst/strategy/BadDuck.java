package headfirst.strategy;

public class BadDuck extends ModelDuck
{
    private int _counter = 1;

    public void performFly() {
        performFlyBadly();
    }

    public void performQuack()
    {
        performQuackBadly();
    }

    private void performFlyBadly()
    {
        if(wantToPerfrom())
        {
            flyBehavior.fly();
        }
    }

    private void performQuackBadly()
    {
        if(wantToPerfrom())
        {
            quackBehavior.quack();
        }
    }

    private boolean wantToPerfrom()
    {
        boolean flag =  (_counter % 2) != 0;
        _counter++;
        return flag;
    }
}
