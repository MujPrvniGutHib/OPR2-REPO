public class Car {
    private final String licensePlate;
    private final CarAction action;
    private final int speed;

    public Car(String licensePlate, CarAction action, int speed) {
        this.licensePlate = licensePlate;
        this.action = action;
        this.speed = speed;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarAction getAction() {
        return action;
    }

    public int getSpeed() {
        return speed;
    }
}
