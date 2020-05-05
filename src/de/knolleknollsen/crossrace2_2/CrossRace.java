package de.knolleknollsen.crossrace2_2;

import java.util.Arrays;
import java.util.Comparator;

public class CrossRace {

    int participants;
    int rounds;
    public MotorBike[] motorBikes;
    Accident accident;

    public CrossRace(int participants, int rounds) {
        this.participants = participants;
        this.rounds = rounds;
        motorBikes = new MotorBike[participants];
        accident = new Accident(motorBikes);
    }

    public void startRace() {
        for (int i = 0; i < participants; i++) {
            motorBikes[i] = new MotorBike(i, rounds);
            motorBikes[i].start();
        }
        accident.start();
    }

    public static void main(String[] args) {
        CrossRace crossRace = new CrossRace(5, 10);
        crossRace.startRace();

        for (Thread motorBike : crossRace.motorBikes) {
            try {
                motorBike.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!crossRace.accident.accidentHappened) {
            Arrays.sort(crossRace.motorBikes, Comparator.comparingInt(MotorBike::getTotalTime));
            System.out.println("**** Endstand ****");
            for (int i = 0; i < crossRace.motorBikes.length; i++) {
                System.out.println((i + 1) + ". PLATZ: MOTORAD " + crossRace.motorBikes[i].number + " Zeit: " + crossRace.motorBikes[i].totalTime);
            }
        }
    }

}
