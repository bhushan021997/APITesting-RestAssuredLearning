package ex_27062024.JacksonAPI.Serelization;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import ex_27062024.GSON.Booking;
import ex_27062024.GSON.BookingDates;

import org.testng.annotations.Test;

public class Lab295 {

    @Test
    public void SeraJackson() throws JsonProcessingException {


        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(-1);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonpayload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonpayload);


    }
}
