package de.knolleknollsen.crossrace2_2;

import java.util.Random;

public class Accident extends Thread {

    Random rng = new Random();



    @Override
    public void run() {
        try {
            sleep(rng.nextInt(1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
