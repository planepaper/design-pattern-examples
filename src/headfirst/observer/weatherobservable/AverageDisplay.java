package headfirst.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;
import java.util.Queue;

public class AverageDisplay implements Observer, DisplayElement
{
    private float temperatureAverage;
    private Queue<Float> queue = new LinkedList<Float>();

    public AverageDisplay(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            float inputTemp = weatherData.getTemperature();
            queue.offer(inputTemp);
            if(queue.size() > 10)
            {
                queue.poll();
            }

            float sum = 0f;
            for (float value : queue) {
                sum += value;
            }

            temperatureAverage = sum / queue.size();

            display();
        }

    }

    public void display() {
        System.out.println("Average up to ten: " + temperatureAverage);
    }
}
