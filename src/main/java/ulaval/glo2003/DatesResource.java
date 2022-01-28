package ulaval.glo2003;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Path("dates")
public class DatesResource {

    @GET
    @Path("to-string")
    public Response getDatesToString() {
        DatesResponse response = new DatesResponse(
                new Date().toString(),
                LocalDate.now().toString(),
                Instant.now().toEpochMilli(),
                LocalDateTime.now().toString(),
                OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC).toString(),
                Instant.now().atOffset(ZoneOffset.UTC).toString(),
                ZonedDateTime.now().toString(),
                Instant.now().atZone(ZoneId.systemDefault()).toString()
        );
        return Response.ok(response).build();
    }

    @GET
    @Path("format-utc")
    public Response getFormattedDatesAtUTC() {
        DatesResponse response = new DatesResponse(
                new Date().toString(),
                LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                Instant.now().toEpochMilli(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME),
                Instant.now().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME),
                ZonedDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME),
                Instant.now().atZone(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME)
        );
        return Response.ok(response).build();
    }

    @GET
    @Path("format-locale")
    public Response getFormattedDatesAtLocalTimezone() {
        DatesResponse response = new DatesResponse(
                new Date().toString(),
                LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                Instant.now().toEpochMilli(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                OffsetDateTime.now().withOffsetSameInstant(OffsetDateTime.now().getOffset()).format(DateTimeFormatter.ISO_DATE_TIME),
                Instant.now().atOffset(OffsetDateTime.now().getOffset()).format(DateTimeFormatter.ISO_DATE_TIME),
                ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                Instant.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_DATE_TIME)
        );
        return Response.ok(response).build();
    }
}
