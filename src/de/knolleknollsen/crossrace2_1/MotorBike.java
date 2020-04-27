package de.knolleknollsen.crossrace2_1;

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
        for (int i = 0; i < rounds ; i++) {
            try {
                int roundTime = rng.nextInt(100);
                Thread.sleep(roundTime);
                totalTime += roundTime;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTotalTime() {
        return totalTime;
    }
}
