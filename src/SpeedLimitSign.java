public class SpeedLimitSign extends TrafficSign {
    private final int maxSpeed;

    public SpeedLimitSign(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
