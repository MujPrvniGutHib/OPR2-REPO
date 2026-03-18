import java.util.ArrayList;
import java.util.List;

public class Location {
    private final String name;
    private final List<Car> cars = new ArrayList<>();
    private final List<TrafficSign> signs = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSign(TrafficSign sign) {
        signs.add(sign);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<TrafficSign> getSigns() {
        return signs;
    }

    public List<Car> getCars() {
        return cars;
    }
}
