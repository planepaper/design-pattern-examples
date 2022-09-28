package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class ClothingStore implements Observer
{
	private static final int SUMMER_CLOTHS = 1;
	private static final int WINTER_CLOTHS = 2;

	private float temperature;
	private float rainfall;
	private int state = SUMMER_CLOTHS;

	public ClothingStore(Observable observable) {
		observable.addObserver(this);
	}

	public void update(Observable observable, Object arg) {
		if (observable instanceof WhetherDataSubject) {
			WhetherDataSubject whetherDataSubject = (WhetherDataSubject)observable;

			if(whetherDataSubject.getTemperature() >= 15.0f) // when temperature exceeds 15.0'c
				state = SUMMER_CLOTHS; // selling summer cloths
			else // when temperature < 15.0
				state = WINTER_CLOTHS;

			temperature = whetherDataSubject.getTemperature();
			rainfall = whetherDataSubject.getRainfall();

			display();
		}
	}

	public void kindOfSellingCloths() {
		System.out.println("Selling " + ((state == SUMMER_CLOTHS) ? "Summer" : "Winter") + " cloths !");
	}

	public void currentState() {
		System.out.printf("===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
				temperature, rainfall);
	}

	public void display() {
		currentState();
		kindOfSellingCloths();
	}
}
