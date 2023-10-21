package API_Test4_PojoClasses.BaseURLDeposu;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBookerHerokuappBaseURL {
    // farklı paketlerden de kalıtım ile kullanabilmek için protected
    protected RequestSpecification spec_json_place;//RequestSpecification => interface
    @Before
    public void setUp(){
        spec_json_place = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }
}
