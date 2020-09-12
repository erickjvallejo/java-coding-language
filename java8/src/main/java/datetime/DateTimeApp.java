package datetime;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeApp {
    public static void main(String[] args) throws InterruptedException, ParseException {

        DateTimeApp app = new DateTimeApp();
        app.compareDatesWith("1.7");
        app.compareDatesWith("1.8");

        app.compareTimeWith("1.7");
        app.compareTimeWith("1.8");

        app.measureTimeWith("1.7");
        app.measureTimeWith("1.8");

        app.FormatDatesWith("1.7");
        app.FormatDatesWith("1.8");

    }

    private void FormatDatesWith(String version) throws ParseException {
        System.out.println("App.FormatDatesWith");
        if (version.equals("1.7")) {
            String date = "07/01/2020";
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date dateConverted = formatter.parse(date);
            System.out.println("dateConverted = " + dateConverted);

            Date currentDate = Calendar.getInstance().getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String strDate = formatter.format(currentDate);
            System.out.println("strDate = " + strDate);
        } else if (version.equals("1.8")) {
            String date = "07/01/2020";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
            System.out.println("localDate = " + localDate);
            System.out.println("localDate = " + dateTimeFormatter.format(localDate));
        }


    }

    private void compareTimeWith(String version) {

        System.out.println("App.compareAndDefineTimeWith");
        if (version.equals("1.8")) {
            LocalTime time1 = LocalTime.of(21, 35, 00);
            LocalTime time2 = LocalTime.now();
            System.out.println("time1 = " + time1);
            System.out.println("time2 = " + time2);
            System.out.println(time1.isBefore(time2));
        } else if (version.equals("1.7")) {
            Calendar time1 = new GregorianCalendar();
            System.out.println("time1 = " + time1.getTime());

            Calendar time2 = new GregorianCalendar();
            time2.set(Calendar.YEAR, 1985);
            time2.set(Calendar.MONTH, Calendar.MAY);
            time2.set(Calendar.DAY_OF_MONTH, 24);
            time2.set(Calendar.HOUR_OF_DAY, 22);
            time2.set(Calendar.MINUTE, 30);
            time2.set(Calendar.SECOND, 00);
            time2.set(Calendar.MILLISECOND, 777);

            System.out.println("time2 = " + time2.getTime());
            System.out.println("time1.before(time2): " + time1.before(time2));

        }
    }

    private void compareDatesWith(String version) {
        System.out.println("App.compareDatesWith");
        if (version.equals("1.7")) {
            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();
            date1.set(1985, 4, 24);
            System.out.println("date1 = " + date1.getTime());
            System.out.println("date2 = " + date2.getTime());
            System.out.println("date1 after date2 : " + date1.after(date2));

        } else if (version.equals("1.8")) {

            LocalDate date3 = LocalDate.of(1985, 05, 24);
            LocalDate date4 = LocalDate.now();
            System.out.println("date3 = " + date3);
            System.out.println("date4 = " + date4);
            System.out.println("date3 isAfter date4 : " + date3.isAfter(date4));

            Period period = Period.between(date3, date4);
            System.out.println("Days = " + period.getDays());
            System.out.println("Months = " + period.getMonths());
            System.out.println("Years = " + period.getYears());
        }

    }

    private void measureTimeWith(String version) throws InterruptedException {

        System.out.println("DateTimeApp.measureTimeWith");
        if (version.equals("1.7")) {
            long start = System.currentTimeMillis();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } else if (version.equals("1.8")) {
            Instant start = Instant.now();
            Thread.sleep(1000);
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end).toMillis());
        }
    }
}
