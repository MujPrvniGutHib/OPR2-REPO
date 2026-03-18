public class ProhibitorySign extends TrafficSign {
    private final CarAction prohibitedAction;

    public ProhibitorySign(CarAction prohibitedAction) {
        this.prohibitedAction = prohibitedAction;
    }

    public CarAction getProhibitedAction() {
        return prohibitedAction;
    }
}
