package API_Test2_TestData;

import API_Test2_TestData.BaseURLDeposu.JsonPlaceHolderBaseURL;
import API_Test2_TestData.TestDataDeposu.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_BaseURL_testdata extends JsonPlaceHolderBaseURL {
    @Test
    public void get_test(){
        //1. Preconditions => Request URL hazırla (gerekli parametre ayarlarını yap)
        spec_json_place.pathParam("pp1",55);

        //2. Expected data yı hazırla
        JsonPlaceHolderTestData jsonplaceholder_testdata = new JsonPlaceHolderTestData();

        JSONObject expected_body = jsonplaceholder_testdata.ExpectedDataOlustur();

        //3. Response u kaydet
        Response response = given().spec(spec_json_place).when().get("/{pp1}");
/*
  response.prettyPrint();
output:
{
    "userId": 6,
    "id": 55,
    "title": "sit vel voluptatem et non libero",
    "body": "debitis excepturi ea perferendis harum libero optio\neos accusamus cum fuga ut sapiente repudiandae\net ut incidunt omnis molestiae\nnihil ut eum odit"
}
 */
        //4. Assertion ile kontrol et => statusCode, ContentType gb.
        response.
                then().
                assertThat().//assertThat ile karşılaştırma yapıyoruz.
                statusCode(200).//beklenen 200 OK kodunu veriyoruz.
                contentType(ContentType.JSON);

        JsonPath actual_body = response.jsonPath(); // dönen response u JsonPath formatında  kaydediyoruz.

        Assert.assertEquals(jsonplaceholder_testdata.ok_basarili,response.getStatusCode()); // status codu kontrol edelim

        Assert.assertEquals(expected_body.get("id"),actual_body.get("id"));

        Assert.assertEquals(expected_body.get("title"),actual_body.get("title"));
        
    }
}
