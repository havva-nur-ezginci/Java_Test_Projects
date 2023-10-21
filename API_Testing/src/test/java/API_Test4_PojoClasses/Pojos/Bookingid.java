package API_Test4_PojoClasses.Pojos;

public class Bookingid {
    /* Response da bookingid de döndüğü için onun pojo class ını hazırlayalım.
      {
   "bookingid": 1240,
   "booking": {
       "firstname": "James",
       "lastname": "Gosling",
       "totalprice": 12345,
       "depositpaid": true,
       "bookingdates": {
           "checkin": "1995-01-01",
           "checkout": "1995-01-01"
       },
       "additionalneeds": "JAVA"
   }
   }
    */
    private int bookingid;
    private Booking booking;

    public Bookingid() {
    }

    public Bookingid(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "bookingid{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
