package de.knolleknollsen.crossrace2_2;

import java.util.Random;

public class MotorBike extends Thread {

    int number;
    int rounds;
    int totalTime;
    Random rng = new Random();

    public MotorBike(int number, int rounds) {
        this.number = number;
        this.rounds = rounds;
    }


    @Override
    public void run() {
        int i;
        for (i = 0; i < rounds && !this.isInterrupted(); i++) {

            try {
                int roundTime = rng.nextInt(100);
                Thread.sleep(roundTime);
                totalTime += roundTime;
            } catch (InterruptedException e) {
                interrupt();
            }
        }

        if (isInterrupted()) {
            System.err.println("Bike: " + number + " stopped in round " + i + " after " + totalTime + " ms because of an accident.");

        } else {
            System.out.println("Bike: " + number + " finished after: " + totalTime + " ms.");
        }
    }

    public int getTotalTime() {
        return totalTime;
    }
}
