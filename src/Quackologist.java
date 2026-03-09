import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Quackologist implements Observer {

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    public void update(QuackObservable duck) {

        String time = LocalTime.now().format(formatter);

        System.out.println("[" + time + "] 🔔 ALERT: "
                + duck + " has quacked!");
    }
}