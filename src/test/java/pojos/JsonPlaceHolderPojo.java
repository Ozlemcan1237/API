package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //Karsidan gelen datayla uyusmamasi durumlarinda kullaniyoruz.Onu gormezden gel diyoruz(Fazla olani id gibi)
public class JsonPlaceHolderPojo {

    private Integer userId;
    private String title;
    private Boolean completed;

//    costructor (bos)    POJO CLASS ICIN SART OLANLAR
//    costructor (dolu)
//    getter-setter
//    toString


    public JsonPlaceHolderPojo() { //DeSerialization yapmamiz icin bos cons.gerek
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
