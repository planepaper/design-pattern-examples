package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class IceCreamStore implements Observer
{
    private float temperature;
    private float rainfall;
    private boolean sellingState = false;

    // default constructor
    public IceCreamStore(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
        if (observable instanceof WhetherDataSubject) {
            WhetherDataSubject whetherDataSubject = (WhetherDataSubject)observable;
            if (whetherDataSubject.getTemperature() >= 20.0f)// when temperature exceeds 20c
                sellingState = true; // selling IceCream
            else // when temperature < 20.0
                sellingState = false;

            temperature = whetherDataSubject.getTemperature();
            rainfall = whetherDataSubject.getRainfall();

            display();
        }
    }

    public void display() {
        currentState();
        isSelling();
        System.out.println();
    }

    public void currentState() {
        System.out.printf("===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
                temperature, rainfall);
    }

    public void isSelling() {
        System.out.print("IceCream ");
        if(sellingState == false){
            System.out.print("is not ");
        }
        System.out.println("Sale !");
    }
}
