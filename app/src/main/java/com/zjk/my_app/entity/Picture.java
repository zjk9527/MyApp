package com.zjk.my_app.entity;

/**
 * Created by zjk on 2017/5/6.
 */

public class Picture {
    private String title;
    private int imageId;

    public Picture() {
    }



    @Override
    public String toString() {
        return "Picture{" +
                "title='" + title + '\'' +
                ", imageId=" + imageId +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Picture(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }
}
