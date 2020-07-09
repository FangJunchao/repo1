package com.xg520.domain;

import java.io.Serializable;
import java.util.Date;

public class LoveProcess implements Serializable {

    private Integer id;
    private String course;
    private Date time;
    private String image;
    private Integer loverId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLoverId() {
        return loverId;
    }

    public void setLoverId(Integer loverId) {
        this.loverId = loverId;
    }

    @Override
    public String toString() {
        return "LoveProcess{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", time=" + time +
                ", image='" + image + '\'' +
                ", loverId=" + loverId +
                '}';
    }
}
