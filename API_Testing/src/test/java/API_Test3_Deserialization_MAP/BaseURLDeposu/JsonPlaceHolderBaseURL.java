package API_Test3_Deserialization_MAP.BaseURLDeposu;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseURL {
    // farklı paketlerden de kalıtım ile kullanabilmek için protected
    protected RequestSpecification spec_json_place;//RequestSpecification => interface
    @Before
    public void setUp(){
        spec_json_place = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com/posts").
                build();
    }

}
