public class DirectionalSign extends TrafficSign {
    private final CarAction allowedAction;

    public DirectionalSign(CarAction allowedAction) {
        this.allowedAction = allowedAction;
    }

    public CarAction getAllowedAction() {
        return allowedAction;
    }
}
