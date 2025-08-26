package pl.coderslab.day1.zad2;

public class Ship {
    private final Captain captain;

    public Ship(Captain captain) {
        this.captain = captain;
    }

    public Captain getCaptain() {
        return captain;
    }
}
