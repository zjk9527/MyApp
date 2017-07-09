package com.zjk.my_app.entity;

/**
 * Created by zjk on 2017/4/22.
 */
public class Banner {


        private String title;

        private String imgUrl;

        private String id;

    public Banner() {
        this.title = title;
        this.imgUrl = imgUrl;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
