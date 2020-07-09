package com.xg520.domain;

import java.io.Serializable;

public class LoveWitness implements Serializable {

    private Integer id;
    private String image;
    private String title;
    private Integer loverId;

    public Integer getLoverId() {
        return loverId;
    }

    public void setLoverId(Integer loverId) {
        this.loverId = loverId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LoveWitness{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", loverId=" + loverId +
                '}';
    }
}
