import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class DateTimeChecker {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                .appendInstant(3)
                .toFormatter()
                .withLocale(Locale.ROOT)
                .withResolverStyle(ResolverStyle.STRICT);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z").withZone(ZoneOffset.UTC);

        System.out.println(format.format(Instant.now().plus(3, ChronoUnit.HOURS)));

        System.out.println("Instant.now().toEpochMilli(): " + Instant.now().toEpochMilli());
        System.out.println("Instant.now(): " + Instant.now());
        System.out.println("new Timestamp(Instant.now().toEpochMilli()): " + new Timestamp(Instant.now().toEpochMilli()));

        Instant bigger = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .parse("2021-09-19T08:42:50.644Z").toInstant();
        Instant now = Instant.now();
        Instant less = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .parse("2021-09-19T07:42:50.644Z").toInstant(); // 2021-09-19T08:42:50.644807Z

//        System.out.println(bigger.compareTo(less));
        System.out.println(TimeUnit.MILLISECONDS.toHours(bigger.toEpochMilli() - less.toEpochMilli()));
        System.out.println(TimeUnit.MILLISECONDS.toHours(now.toEpochMilli() - less.toEpochMilli()));
        System.out.println(less);
        System.out.println(Long.valueOf("720"));
//        long diff = Period.between(less, bigger);


//
//        String timeStamp = "2020-02-08T09:30:26.123Z";
//        System.out.println(timeStamp.length());
//        System.out.println(timeStamp.charAt(23));
//
//        System.out.println(dtf.format(dtf.parse(timeStamp)));
    }
}