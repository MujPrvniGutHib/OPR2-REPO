import java.util.ArrayList;
import java.util.List;

public class Officer {
    private final String name;

    public Officer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Fine> inspectLocation(Location location) {
        List<Fine> allFines = new ArrayList<>();
        FineManager manager = new FineManager();

        for (Car car : location.getCars()) {
            allFines.addAll(manager.checkViolations(car, location));
        }

        return allFines;
    }
}
