package de.knolleknollsen.crossrace2_2;

import java.util.Arrays;
import java.util.Comparator;

public class CrossRace {

    int participants;
    int rounds;
    public MotorBike[] motorBikes;
    Accident accident = new Accident();

    public CrossRace(int participants, int rounds) {
        this.participants = participants;
        this.rounds = rounds;
        motorBikes = new MotorBike[participants];
    }

    public void startRace() {
        accident.start();
        for (int i = 0; i < participants; i++) {
            motorBikes[i] = new MotorBike(i, rounds);
            motorBikes[i].start();
        }

        boolean allFinished = false;
        while (!allFinished) {
            if (!accident.isAlive()) {
                for (Thread thread : motorBikes) {
                    thread.interrupt();
                }
                return;
            }
            allFinished = true;
            for (Thread thread : motorBikes) {
                if (thread.isAlive()) {
                    allFinished = false;
                    break;
                }
            }
        }

        Arrays.sort(motorBikes, Comparator.comparingInt(MotorBike::getTotalTime));
        System.out.println("**** Endstand ****");
        for (int i = 0; i < motorBikes.length; i++) {
            System.out.println((i + 1) + ". PLATZ: MOTORAD " + motorBikes[i].number + " Zeit: " + motorBikes[i].totalTime);
        }

    }

    public static void main(String[] args) {
        CrossRace crossRace = new CrossRace(5, 10);
        crossRace.startRace();
    }
}
