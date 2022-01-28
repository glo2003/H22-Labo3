package ulaval.glo2003;

public class DatesResponse {
    public final String date;
    public final String localDate;
    public final Long instant;
    public final String localDateTime;
    public final String offsetDateTime1;
    public final String offsetDateTime2;
    public final String zonedDateTime1;
    public final String zonedDateTime2;

    public DatesResponse(String date, String localDate, Long instant, String localDateTime, String offsetDateTime1, String offsetDateTime2, String zonedDateTime1, String zonedDateTime2) {
        this.date = date;
        this.localDate = localDate;
        this.instant = instant;
        this.localDateTime = localDateTime;
        this.offsetDateTime1 = offsetDateTime1;
        this.offsetDateTime2 = offsetDateTime2;
        this.zonedDateTime1 = zonedDateTime1;
        this.zonedDateTime2 = zonedDateTime2;
    }
}
