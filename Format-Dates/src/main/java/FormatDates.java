import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {

        //Get the current date and time
        LocalDate todayDate =LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        //GMT time
        ZonedDateTime gmtTime = now.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT")); // Convert it to GMT without changing the actual moment in time

        //  MM/dd/yyyy format
        System.out.println(todayDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        // yyyy-MM-dd(default)
        System.out.println(todayDate);

        //MMMM dd,yyyy
        System.out.println(todayDate.format(DateTimeFormatter.ofPattern("MMMM dd,yyyy" )));

        //day, apr d.yyyy in GMT
        System.out.println(gmtTime.format(DateTimeFormatter.ofPattern("EEEE, MMM M, yyyy HH:mm:")));

        //in GMT
        System.out.println(gmtTime.format(DateTimeFormatter.ofPattern("HH:mm 'on' dd-MMM-yyyy")));

    }
}
