package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String, String> bookingdatesMapMethod(String checkin, String checkout) {
        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", checkin);
        bookingdatesMap.put("checkout", checkout);
        return bookingdatesMap;
    }

    public Map<String, Object> ecpectedDataMethod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdatesMap, String additionalneeds) {
        Map<String, Object> ecpectedData = new HashMap<>();
        ecpectedData.put("firstname", firstname);
        ecpectedData.put("lastname", lastname);
        ecpectedData.put("totalprice", totalprice);
        ecpectedData.put("depositpaid", depositpaid);
        ecpectedData.put("bookingdates", bookingdatesMap);
        if (additionalneeds!=null){
            ecpectedData.put("additionalneeds", additionalneeds);
        }
        return ecpectedData;
    }
}
