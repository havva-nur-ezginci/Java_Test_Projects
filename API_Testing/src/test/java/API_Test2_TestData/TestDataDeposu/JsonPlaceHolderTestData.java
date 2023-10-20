package API_Test2_TestData.TestDataDeposu;

import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class JsonPlaceHolderTestData {
    /* her seferinde datayı tekrar tekrar oluşturmamak için tek sefer oluşturup
    istediğimizde kullanalım.
     */
    public int ok_basarili = 200;

    public JSONObject ExpectedDataOlustur(){
        //2. Expected data yı hazırla
        JSONObject expected_body = new JSONObject();
        expected_body.put("userId",6);
        expected_body.put("id",55);
        expected_body.put("title","sit vel voluptatem et non libero");
        expected_body.put("body","debitis excepturi ea perferendis harum libero optio\neos accusamus cum fuga ut sapiente repudiandae\net ut incidunt omnis molestiae\nnihil ut eum odit");

        return expected_body;
    }
}