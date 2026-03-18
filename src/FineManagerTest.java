import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FineManagerTest {

    @Test
    public void testSpeedingViolation() {
        Location location = new Location("Hlavni trida");
        location.addSign(new SpeedLimitSign(50));
        Car car = new Car("1A1 1234", CarAction.DRIVING_STRAIGHT, 70);
        FineManager manager = new FineManager();

        List<Fine> fines = manager.checkViolations(car, location);

        assertEquals(1, fines.size());
        assertEquals("Prekroceni rychlosti", fines.get(0).getReason());
    }

    @Test
    public void testSpeedingWithoutSign() {
        Location location = new Location("Bez omezeni");
        Car car = new Car("1A1 1234", CarAction.SPEEDING, 70);
        FineManager manager = new FineManager();

        List<Fine> fines = manager.checkViolations(car, location);

        assertTrue(fines.isEmpty());
    }

    @Test
    public void testForbiddenActionViolation() {
        Location location = new Location("Zakaz zastaveni");
        location.addSign(new ProhibitorySign(CarAction.PARKING));
        Car car = new Car("2B2 5678", CarAction.PARKING, 0);
        FineManager manager = new FineManager();

        List<Fine> fines = manager.checkViolations(car, location);

        assertEquals(1, fines.size());
        assertEquals("Zakazana akce", fines.get(0).getReason());
    }

    @Test
    public void testMultipleViolations() {
        Location location = new Location("Prujezd");
        location.addSign(new ProhibitorySign(CarAction.TURNING));
        location.addSign(new SpeedLimitSign(30));
        Car car = new Car("3C3 9012", CarAction.TURNING, 50);
        FineManager manager = new FineManager();

        List<Fine> fines = manager.checkViolations(car, location);

        assertEquals(2, fines.size());
    }

    @Test
    public void testDirectionalSignViolation() {
        Location location = new Location("Jednosmerka");
        location.addSign(new DirectionalSign(CarAction.DRIVING_STRAIGHT));
        Car car = new Car("5E5 7890", CarAction.TURNING, 20);
        FineManager manager = new FineManager();

        List<Fine> fines = manager.checkViolations(car, location);

        assertEquals(1, fines.size());
        assertEquals("Spatny smer", fines.get(0).getReason());
    }

    @Test
    public void testNoViolations() {
        Location location = new Location("V poradku");
        location.addSign(new ProhibitorySign(CarAction.TURNING));
        location.addSign(new SpeedLimitSign(50));
        Car car = new Car("4D4 3456", CarAction.PARKING, 0);
        FineManager manager = new FineManager();

        List<Fine> fines = manager.checkViolations(car, location);

        assertTrue(fines.isEmpty());
    }
}
