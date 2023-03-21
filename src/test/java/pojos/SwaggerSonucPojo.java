package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwaggerSonucPojo {
    /*

                                                "code": 200,
                                                "type": "unknown",
     */
    private Integer code;
    private String type;

    public SwaggerSonucPojo() {
    }

    public SwaggerSonucPojo(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SwaggerSonucPojo{" +
                "code=" + code +
                ", type='" + type + '\'' +
                '}';
    }
}
