package de.knolleknollsen.crossrace2_2;

import java.util.Random;

public class Accident extends Thread {

    Random rng = new Random();
    MotorBike[] bikes;
    public boolean accidentHappened = false;

    public Accident(MotorBike[] bikes) {
        this.bikes = bikes;
    }

    @Override
    public void run() {
        try {
            sleep(rng.nextInt(750 - 300) + 300);
            accidentHappened = true;
            for (Thread thread : bikes) {
                thread.interrupt();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
