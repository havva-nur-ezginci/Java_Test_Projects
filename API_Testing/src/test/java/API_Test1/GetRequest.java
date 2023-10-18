package API_Test1;
//1. study
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

// https://jsonplaceholder.typicode.com/

public class GetRequest {
    @Test
    public void get_test() {
    /*
    https://jsonplaceholder.typicode.com/posts/55 url ni kullan

    Request için preconditions (ön koşullar) => Request URL ve Body oluşturulmalıdır.
    GET metodu için body e gerek yok.
    GET request sonucunda dönen response un kontrollerini yap.

     */
        //1. Preconditions => Request URL
        String url = "https://jsonplaceholder.typicode.com/posts/55";

        //2. Expected data yı hazırla
        JSONObject expected_body = new JSONObject();
        expected_body.put("id",55);
        expected_body.put("title","sit vel voluptatem et non libero");

        //3. Response u kaydet
        Response response = given().when().get(url);
        /// response.prettyPrint(); => response un bize sağladığı buna benzer avantajlar vardır.

        //4. Assertion ile kontrol et => statusCode, ContentType
        response.
                then().
                assertThat().//assertThat ile karşılaştırma yapıyoruz.
                statusCode(200).//beklenen 200 OK kodunu veriyoruz.
                contentType(ContentType.JSON);

        JsonPath actual_body = response.jsonPath(); // dönen response u JsonPath formatında  kaydediyoruz.

        Assert.assertEquals(expected_body.get("id"),actual_body.get("id"));

        Assert.assertEquals(expected_body.get("title"),actual_body.get("title"));


    }


}
