import java.util.Date;

public class Fine {
    private final double amount;
    private final String reason;
    private final Date timestamp;

    public Fine(double amount, String reason) {
        this.amount = amount;
        this.reason = reason;
        this.timestamp = new Date();
    }
}
