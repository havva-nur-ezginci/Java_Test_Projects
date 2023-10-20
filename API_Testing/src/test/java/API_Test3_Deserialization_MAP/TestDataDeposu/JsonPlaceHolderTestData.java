package API_Test3_Deserialization_MAP.TestDataDeposu;

import net.minidev.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String,Object> RequestBodyMapOlustur(){
        //1. Preconditions : request body hazırla
        Map <String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("title","çalışan");
        requestBodyMap.put("body","yönetici yağmur");
        requestBodyMap.put("userId",3.0);
        requestBodyMap.put("id",33.0);
        return  requestBodyMap;
    }
}