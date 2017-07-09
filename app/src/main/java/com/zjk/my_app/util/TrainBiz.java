package com.zjk.my_app.util;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;


import com.zjk.my_app.entity.Brand;

public class TrainBiz {
	public static List<Brand.ResultBean> getTrainsByNumberTypeSelected(String str, List<Brand.ResultBean> trains){
		List<Brand.ResultBean> trains5=new ArrayList<>();
		Log.i("TAG", String.valueOf(trains.size()));

		for(Brand.ResultBean a:trains) {
			String tNumber = a.getInitial();

			if (tNumber.equals(str)) {
				trains5.add(a);
			} continue;
			}


		return trains5;}

	//当输入为汉字时
	public static List<Brand.ResultBean> getTrainsByNumberTypeSelected1(String str, List<Brand.ResultBean> trains1){
		List<Brand.ResultBean> trains6=new ArrayList<>();
		for (Brand.ResultBean b:trains1){
			String hNumber=b.getName();
			if (hNumber.equals(str)){
				trains6.add(b);
			} continue;
		}
		return trains6;}

}

	


