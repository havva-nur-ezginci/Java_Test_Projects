package API_Test3_Deserialization_MAP;
//1. study
import API_Test3_Deserialization_MAP.BaseURLDeposu.JsonPlaceHolderBaseURL;
import API_Test3_Deserialization_MAP.TestDataDeposu.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

/*
 PUT ilgili adrese erişilir ve eğer içerik var ise gelen veriler ile değiştirilir,
 eğer içerik yok ise yeni içerik oluşturulur. PUT veri güncellemek için kullanılır.
*/
public class PutRequest_Map extends JsonPlaceHolderBaseURL {
    /*
PUT request yap.
    Body örnek;
    {
    title: 'çalışan',
    body: 'yönetici yağmur',
    userId: 3.0,
    id: 123456789.0
    }
 */
    @Test
    public void put_test(){
        //1. Preconditions => Request URL ve body hazırla
        spec_json_place.pathParam("pp1",33);

        JsonPlaceHolderTestData jsonplaceholder_testdata = new JsonPlaceHolderTestData();

        Map<String,Object> request_body_map = jsonplaceholder_testdata.RequestBodyMapOlustur();

        /*
        System.out.println(request_body_map);
        output: {id=33.0, title=çalışan, body=yönetici yağmur, userId=3.0}
         */
        //2. Expected data yı hazırla
        Map<String,Object> expected_body_map = jsonplaceholder_testdata.RequestBodyMapOlustur();

        //3. Response u kaydet
        Response response = given().
                contentType(ContentType.JSON).// response u hangi type ile almak istediğimizi belirttik
                spec(spec_json_place).//url i verdik
                when().
                body(request_body_map).
                put("/{pp1}");

 /* response.prettyPrint();
       output:
       {
    "id": 33,
    "title": "çalışan",
    "body": "yönetici yağmur",
    "userId": 3
}*/
        //4. Assertion ile kontrol et => statusCode gb.

        Map<String,Object> response_body_map = response.as(HashMap.class); // dönen response u Map formatında  kaydediyoruz.

        // header kısmı direk response dan kontrol edilir.
        Assert.assertEquals(jsonplaceholder_testdata.ok_basarili,response.getStatusCode());

        // Map içeriklerini karşılaştıralım.
        Assert.assertEquals(expected_body_map.get("id"),response_body_map.get("id"));

        Assert.assertEquals(expected_body_map.get("title"),response_body_map.get("title"));

        Assert.assertEquals(expected_body_map.get("userId"),response_body_map.get("userId"));

        Assert.assertEquals(expected_body_map.get("body"),response_body_map.get("body"));
    }
}
