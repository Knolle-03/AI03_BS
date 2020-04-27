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
        for (int i = 0; i < rounds ; i++) {
//            if (interrupted()){
//                System.out.println("Motorad " + number + " aborted the race.");
//                return;
//            }
            try {
                int roundTime = rng.nextInt(100);
                Thread.sleep(roundTime);
                totalTime += roundTime;
            } catch (InterruptedException e) {
                System.out.println("Motorad " + number + " stopped.");
                return;
            }
        }
    }

    public int getTotalTime() {
        return totalTime;
    }
}
