package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {

    protected RequestSpecification spec;
//    baska package den ulasmak ıstedgımız ıcın protected yaptık

    @Before // Her @Test metodundan once calisir
    public void setUp(){

        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBaseUri("https://dummy.restapiexample.com/").
                build();
    }
}
//          Request lerimizi spesifik hale getirdik bu classta