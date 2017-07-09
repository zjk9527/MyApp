package com.zjk.my_app.Test;

import android.widget.BaseAdapter;

import com.zjk.my_app.entity.Brand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/26.
 */

public class TestSreachCarBrand {

    //通过车品牌的首写字母查得所有以该首字母开头的汽车品牌集合，提起判定用户输入的是汉字还是拼音字母，且注意大小写的转换
    public static List<String> getCarBrandByPyF(List<Brand.ResultBean> brandList,String py){
        List<String> list=new ArrayList();
        try {
            if (brandList != null) {
                for (Brand.ResultBean carBrand : brandList) {
                            if(py.equals(carBrand.getInitial())){
                                String brandName=carBrand.getName();
                                list.add(brandName);
                            }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //通过车品牌的查得所有以该首汉字开头的汽车品牌集合，提起判定用户输入的是汉字还是拼音字母，且注意大小写的转换
    public static  List<String> getCarBrandByHzF(List<Brand.ResultBean> brandList,String py) {
        List<String> list = new ArrayList();
        try {
            if (brandList != null) {
                for (Brand.ResultBean carBrand : brandList) {
                    if (py.equals(carBrand.getName().charAt(0))) {
                        String brandName = carBrand.getName();
                        list.add(brandName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /*//判断用户输入的是否是字母或者汉字
    public void get(String str){
        try {
            if (str.matches(['A~Z'])){


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

}
