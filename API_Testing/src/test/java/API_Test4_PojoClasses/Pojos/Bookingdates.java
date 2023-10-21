package API_Test4_PojoClasses.Pojos;
/*
pojo class ını oluşturma :
1.	Private variable ları instance class ında oluştur
2.	Bu variable ların getter ve setter larını oluştur
3.	Bütün variableları parametre olarak içeren constructor oluştur
4.	Parametreli constructor oluşturduğumuzdan dolayı default parametresiz constructor oluştur.
5.	Oluşturduğumuz variablları toString metoduyla stringe dönüştürüyoruz.
 */

public class Bookingdates {
    /*
    "bookingdates" : {
        "checkin" : "1995-01-01",
        "checkout" : "1995-01-01"
    },
     */
    private String checkin;
    private String checkout;

    public Bookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Bookingdates() {
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    @Override
    public String toString() {
        return "Bookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
