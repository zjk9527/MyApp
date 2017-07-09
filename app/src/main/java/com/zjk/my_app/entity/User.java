package com.zjk.my_app.entity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by zjk on 2017/6/12.
 */

public class User extends BmobUser {

    private String name;//用户名
    private String desc;//个人简介
    private BmobFile avatar;//图像地址
    private String classes;// 类别

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BmobFile getAvatar() {
        return avatar;
    }

    public void setAvatar(BmobFile avatar) {
        this.avatar = avatar;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String Classes) {
        this.classes = Classes;
    }
}
