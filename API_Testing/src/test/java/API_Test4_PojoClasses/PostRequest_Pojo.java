package API_Test4_PojoClasses;
// 1. study
import API_Test4_PojoClasses.BaseURLDeposu.RestfulBookerHerokuappBaseURL;
import API_Test4_PojoClasses.Pojos.Booking;
import API_Test4_PojoClasses.Pojos.Bookingdates;
import API_Test4_PojoClasses.Pojos.Bookingid;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
{
    "firstname" : "James",
    "lastname" : "Gosling",
    "totalprice" : 12345,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "1995-01-01",
        "checkout" : "1995-01-01"
    },
    "additionalneeds" : "JAVA"
}
java objesi için pojo classes oluşturalım. Oluşturmaya en içte olandan başla.

https://restful-booker.herokuapp.com/booking => POST işlemi yap.
 */
public class PostRequest_Pojo extends RestfulBookerHerokuappBaseURL {

    @Test
    public void post_pojo_test(){
        //1. Preconditions => Request URL ve body hazırla
        spec_json_place.pathParam("pp1","booking");//url oluşturuldu

        Bookingdates bookingdates = new Bookingdates("1995-01-01","1995-01-01");
        //Bookingdates{checkin='1995-01-01', checkout='1995-01-01'}
        Booking booking = new Booking("James","Gosling",12345,true,bookingdates,"JAVA");
        //Booking{firstname='James', lastname='Gosling', totalprice=12345, depositpaid=true, bookingdates=Bookingdates{checkin='1995-01-01', checkout='1995-01-01'}, additionalneeds='JAVA'}

        //2. Expected data yı hazırla
        Bookingid bookingid = new Bookingid(1240,booking);//Dönen response a göre yeni pojo class ımız hazırladık.

        //3. Response u kaydet
        Response response = given().
                contentType(ContentType.JSON).// response u hangi type ile almak istediğimizi belirttik
                spec(spec_json_place).//url i verdik
                body(booking).
                when().
                post("/{pp1}");

        Bookingid response_body = response.as(Bookingid.class);// Json tipinde dönen responsumuzu Bookingid tipine dönüştürdük.

/*
        response.prettyPrint();
        output:
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

        //4. Assertion ile kontrol et
        Assert.assertEquals(200,response.getStatusCode());
       // id hariç, id her post için farklı değerler atayabilir.
        Assert.assertEquals(bookingid.getBooking().toString(),response_body.getBooking().toString());


        /*System.out.println(bookingid.getBooking().toString());
        Booking{firstname='James', lastname='Gosling', totalprice=12345, depositpaid=true, bookingdates=Bookingdates{checkin='1995-01-01', checkout='1995-01-01'}, additionalneeds='JAVA'}

        System.out.println("--------------------------------------------------------------");

        System.out.println(response_body.getBooking().toString());
        Booking{firstname='James', lastname='Gosling', totalprice=12345, depositpaid=true, bookingdates=Bookingdates{checkin='1995-01-01', checkout='1995-01-01'}, additionalneeds='JAVA'}

         */




    }




}
