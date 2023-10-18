package API_Test1;
//2. study
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {
    @Test
    public void post_test(){
        /*
    https://jsonplaceholder.typicode.com/posts url ni kullanarak POST request yap.
    Body örnek;
    {
    title: 'foo',
    body: 'bar',
    userId: 1,
    }
    https://jsonplaceholder.typicode.com/guide/ => çözülmüş örnekden yararlanabilirsin.

    Request için preconditions (ön koşullar) => Request URL ve Body oluşturulmalıdır.

    status code 201 döndüğünü manuel olarak yapılan .png görselinde görebiliriz.

     */
        //1. Preconditions => Request URL ve body hazırla
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject request_body = new JSONObject();
        request_body.put("title","Java");
        request_body.put("body","API Testing");
        request_body.put("userId",122);

        //2. Expected data yı hazırla

        JSONObject expected_body = new JSONObject();
        expected_body.put("title","Java");
        expected_body.put("body","API Testing");
        expected_body.put("userId",122);

        //3. Response u kaydet
        Response response = given().
                contentType(ContentType.JSON).// response u hangi type ile almak istediğimizi belirttik
                when().
                body(request_body.toString()). // request body verdik
                post(url); // ilgili url e post işlemini yaptık.

        JsonPath actual_body = response.jsonPath();

        //4. Assertion ile kontrol et

        response
                .then() // sorgu yapacağımızda then kullanıyoruz.
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201);

        Assert.assertEquals(expected_body.get("title"),actual_body.get("title"));
        Assert.assertEquals(expected_body.get("body"),actual_body.get("body"));
        Assert.assertEquals(expected_body.get("userId"),actual_body.get("userId"));

    }
}
