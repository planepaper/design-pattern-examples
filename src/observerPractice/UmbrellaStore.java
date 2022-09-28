package observerPractice;

import java.util.Observer;
import java.util.Observable;

public class UmbrellaStore implements Observer
{
	private float temperature;
	private float rainfall;
	private boolean sellingState = false;
	// default constructor

	public UmbrellaStore(Observable observable) {
		observable.addObserver(this);
	}

	public void update(Observable observable, Object arg) {
		if (observable instanceof WhetherDataSubject) {
			WhetherDataSubject whetherDataSubject = (WhetherDataSubject)observable;
			if (whetherDataSubject.getRainfall() >= 5.0f)// when rainfall exceeds 5.0mm
				sellingState = true; // selling umbrella
			else // when rainfall < 5.0
				sellingState = false;

			temperature = whetherDataSubject.getTemperature();
			rainfall = whetherDataSubject.getRainfall();

			display();
		}
	}

	public void display() {
		currentState();
		isSelling();
	}

	public void currentState() {
		System.out.printf("===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
				temperature, rainfall);
	}

	public void isSelling() {
		System.out.print("Umbrellas ");
		if(sellingState == false){
			System.out.print("is not ");
		}
		System.out.println("Sale !");
	}
}
