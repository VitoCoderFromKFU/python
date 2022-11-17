package interfacesAndClasses;

//import java.nio.charset.StandardCharsets;

import java.util.Locale;
import java.util.Scanner;

interface Vehicle {
    void move();

    void stop();

    double getMaxSpeed();

    void setMaxSpeed(double maxSpeed);
}

abstract class PublicTransport implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1) + " moved");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1) + " stopped");
    }

    abstract void setAmountStops(int amountStops);

    abstract int getAmountStops();
}

class Tram extends PublicTransport {
    private double maxSpeed;
    private int amountStops;
    boolean isConnected;

    Tram(double maxSpeed, int amountStops, boolean isConnected) {
        setMaxSpeed(maxSpeed);
        setAmountStops(amountStops);
        this.isConnected = isConnected;
    }

    @Override
    public double getMaxSpeed() {
        System.out.println("Max speed = " + maxSpeed);
        return maxSpeed;
    }

    @Override
    int getAmountStops() {
        System.out.println("Amount stops = " + amountStops);
        return this.amountStops;
    }

    @Override
    void setAmountStops(int amountStops) {
        this.amountStops = amountStops;
    }

    @Override
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    void connectToElectricity() {
        this.isConnected = true;
        System.out.println("Tram connected to electricity");
    }

    void disconnectFromElectricity() {
        this.isConnected = false;
        System.out.println("Tram disconnected from electricity");
    }

}


public class Task1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double maxSpeed = scanner.nextFloat();
        int amountStops = scanner.nextInt();
        boolean isConnected = scanner.nextBoolean();
        Tram t = new Tram(maxSpeed, amountStops, isConnected);
        t.connectToElectricity();
        t.move();
        t.getMaxSpeed();
        t.getAmountStops();
        t.stop();
        t.disconnectFromElectricity();
        t.getMaxSpeed();
        t.getAmountStops();
    }
}
