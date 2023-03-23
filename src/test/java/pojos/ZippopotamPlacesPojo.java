package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZippopotamPlacesPojo {
    /*

            "place name": "Vitoria-Gasteiz",
            "longitude": "-2.6667",
            "state": "Pais Vasco",
            "state abbreviation": "PV",
            "latitude": "42.85"
     */
    private String place_name;
    private String longitude;
    private String state;
    private String state_abbreviation;
    private String latitude;

    public ZippopotamPlacesPojo() {
    }

    public ZippopotamPlacesPojo(String place_name, String longitude, String state, String state_abbreviation, String latitude) {
        this.place_name = place_name;
        this.longitude = longitude;
        this.state = state;
        this.state_abbreviation = state_abbreviation;
        this.latitude = latitude;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_abbreviation() {
        return state_abbreviation;
    }

    public void setState_abbreviation(String state_abbreviation) {
        this.state_abbreviation = state_abbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "ZippopotamPlacesPojo{" +
                "place_name='" + place_name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", state_abbreviation='" + state_abbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
