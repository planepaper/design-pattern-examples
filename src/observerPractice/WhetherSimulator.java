package observerPractice;

public class WhetherSimulator {
	
	
	public static void main(String[] args) {
		WhetherDataSubject wdSubject = new WhetherDataSubject();

		UmbrellaStore umbrellaStore = new UmbrellaStore(wdSubject);
		ClothingStore clothingStore = new ClothingStore(wdSubject);
		IceCreamStore iceCreamStore = new IceCreamStore(wdSubject);


		wdSubject.setMeasurements(10.0f, 10.0f);
		wdSubject.setMeasurements(16.0f, 1.0f);
		wdSubject.setMeasurements(21.0f, 1.0f);
	}
}
