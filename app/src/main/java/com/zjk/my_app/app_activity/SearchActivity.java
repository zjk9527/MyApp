package com.zjk.my_app.app_activity;

import android.app.Activity;

import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.zjk.my_app.R;
import com.zjk.my_app.adapter.SearchAdapter;
import com.zjk.my_app.fragment.NearbyFragment;
import com.zjk.my_app.util.ClearEditText;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {
    private ClearEditText clearEditText;
    private ImageView iv_Actionbar_Left;
    private ListView listview;
    private PoiSearch poiSearch;
    private List<PoiInfo> poiInfo;
    private SearchAdapter adapter;
    private GeoCoder search=null;
    private String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setOrientationPortrait();
        initView();
        setListener();
    }


    private void initView() {


        city=getIntent().getStringExtra("city");
        poiSearch=PoiSearch.newInstance();
        poiInfo=new ArrayList<>();
        adapter=new SearchAdapter(this,poiInfo);
        listview= (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        clearEditText = (ClearEditText) findViewById(R.id.clearEditText);
        clearEditText.setText("");
        iv_Actionbar_Left= (ImageView) findViewById(R.id.imageView_Actionbar_Left1);
    }
    private void setListener() {
        iv_Actionbar_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this, NearbyFragment.class);
                onBackPressed();
            }
        });
        //根据所在城市的地址 转换成经纬度点击后 跳到地图上显示
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                search.geocode(new GeoCodeOption().city(city).
                        address(poiInfo.get(position).address));
            }
        });
        search=GeoCoder.newInstance();
        //得到经纬度
        search.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                if (geoCodeResult.getLocation()!=null){
                    Intent intent=new Intent();
                    intent.putExtra("latitude",geoCodeResult.getLocation().latitude+"");
                    intent.putExtra("longitude",geoCodeResult.getLocation().longitude+"");
                    setResult(1,intent);
                    SearchActivity.this.finish();
                }
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

            }
        });
        //刷新查询的数据
        clearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                    initData(clearEditText.getText().toString());
            }
        });
    }

    private void initData(String key) {
        OnGetPoiSearchResultListener poiSearchResultListener=new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {
                poiInfo.clear();
                if (poiResult.getAllPoi()!=null){
                    poiInfo.addAll(poiResult.getAllPoi());
                    adapter.notifyDataSetChanged();
                } else{
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
            }
            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
            }
        };
        poiSearch.setOnGetPoiSearchResultListener(poiSearchResultListener);
        poiSearch.searchInCity((new PoiCitySearchOption())
                .city(city).keyword(key));
    }

}
