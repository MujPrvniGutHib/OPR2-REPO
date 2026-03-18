import java.util.ArrayList;
import java.util.List;

public class FineManager {

    public List<Fine> checkViolations(Car car, Location location) {
        List<Fine> fines = new ArrayList<>();

        for (TrafficSign sign : location.getSigns()) {
            if (sign instanceof ProhibitorySign prohibitorySign) {
                if (car.getAction() == prohibitorySign.getProhibitedAction()) {
                    fines.add(new Fine(500, "Zakazana akce"));
                }
            } else if (sign instanceof SpeedLimitSign speedLimitSign) {
                if (car.getSpeed() > speedLimitSign.getMaxSpeed()) {
                    fines.add(new Fine(1000, "Prekroceni rychlosti"));
                }
            } else if (sign instanceof DirectionalSign directionalSign) {
                if (car.getAction() != directionalSign.getAllowedAction() && isMovement(car.getAction())) {
                    fines.add(new Fine(300, "Spatny smer"));
                }
            }
        }
        
        return fines;
    }

    private boolean isMovement(CarAction action) {
        return action == CarAction.TURNING || action == CarAction.DRIVING_STRAIGHT || action == CarAction.SPEEDING;
    }
}
