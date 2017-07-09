package com.zjk.my_app.fragment;



import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.TextureMapFragment;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.zjk.my_app.R;
import com.zjk.my_app.adapter.SystemBarTintManager;
import com.zjk.my_app.app_activity.SearchActivity;
import com.zjk.my_app.util.PermissionHelper;



import java.util.List;

import static cn.bmob.v3.Bmob.getApplicationContext;


/**
 *   地图界面
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends BaseFragment {
    //private PermissionHelper  mPermissionHelper=new PermissionHelper(getActivity());
    private String appId = "c46bf95c82e78765";
    private String appSecret = "ba669ff367af19e9";

    private View view;
    private TextureMapView mMapView = null;
    private BaiduMap baiduMap;
    private ImageView iv_locating;
    private LocationClient locationClient=null;
    private BDLocationListener locationListener=new MyLocationListener();
    private double latitude,latitudeLocation;
    private double longitude,longitudeLocation;
    private String addressLocation;
    private GeoCoder search=null;
    private TextView tv_address,tv_search ;
    private static final int BAIDU_READ_PHONE_STATE =100;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplicationContext());
        view = inflater.inflate(R.layout.fragment_nearby, container, false);
       // AdManager.getInstance(getActivity()).init(appId,appSecret,true);

        //获取版本信息是否是6.0等
        if (Build.VERSION.SDK_INT>=23){
            //如果版本号为23  6.0的  调用此方法
          showContacts();

           // mPermissionHelper.applyPermissions();
        }else{
            //调用定位的方法
           location(latitudeLocation, longitudeLocation);
            //showCurrentPosition();
        }


        //竖屏
        setOrientationPortrait();
        initView();
        setListener();
        return view;
    }
    public void showContacts(){
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)
                !=PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.RECORD_AUDIO)
                !=PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"没有权限,请手动开启定位权限",Toast.LENGTH_SHORT).show();
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE
            ,Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO}, BAIDU_READ_PHONE_STATE);
        }else{
            //调用定位的方法

            //location(latitudeLocation, longitudeLocation);
            // showCurrentPosition();
        }
    }



    //Android6.0申请权限的回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            // requestCode即所声明的权限获取码，在checkSelfPermission时传入
            case BAIDU_READ_PHONE_STATE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获取到权限，作相应处理（调用定位SDK应当确保相关权限均被授权，否则可能引起定位失败）
                    //调用定位的方法
                    //showCurrentPosition();
                    location(latitudeLocation, longitudeLocation);
                } else {
                    // 没有获取到权限，做特殊处理
                    Toast.makeText(getApplicationContext(), "获取位置权限失败，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void initView() {
        
        mMapView = (TextureMapView) view.findViewById(R.id.bmapView);
        tv_search= (TextView) view.findViewById(R.id.tv_search);
        tv_address= (TextView) view.findViewById(R.id.tv_address);
        iv_locating= (ImageView) view.findViewById(R.id.iv_locating);
        baiduMap=mMapView.getMap();
        locationClient=new LocationClient(getApplicationContext());
        locationClient.registerLocationListener(locationListener);
        initLocation();
        locationClient.start();
    }



    private void setListener() {

        baiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {
            }
            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
            }
            //屏幕中间的经纬度
            @Override
            public void onMapStatusChangeFinish(final MapStatus mapStatus) {
                latitude = mapStatus.target.latitude;
                longitude = mapStatus.target.longitude;
                LatLng ptCenter = new LatLng(latitude, longitude);
                search.reverseGeoCode(new ReverseGeoCodeOption().location(ptCenter));
            }
        });
        search= GeoCoder.newInstance();
        /**根据经纬度得到屏幕中心点地址**/
        search.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }
            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                    Toast.makeText(getActivity(), "抱歉，未能找到结果", Toast.LENGTH_LONG).show();
                    return;
                }
                baiduMap.clear();
                baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result.getLocation()));
                addressLocation = result.getAddress();
                tv_address.setText(result.getAddress());
                getCity();

            }
        });
        //跳转到搜索界面
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("city",tv_search.getText().toString());
                startActivityForResult(intent,0);
            }
        });
        /**返回当前的定位点**/
            iv_locating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    location(latitudeLocation,longitudeLocation);
                }
            });
    }

    /**经纬度地址动画显示在屏幕中间**/
    private void location(double latitude,double longitude){
        LatLng ll = new LatLng(latitude, longitude);
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(ll);
        baiduMap.animateMapStatus(msu);
        tv_address.setText(addressLocation);
        getCity();
    }

    /**接收异步返回的定位结果**/
    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation){// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.e("BaiduLocationApiDem", sb.toString());
            showCurrentPosition(location);
        }
    }
    /**配置定位SDK参数**/
    private void initLocation(){
        LocationClientOption option=new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //1. WGS84：为一种大地坐标系，也是目前广泛使用的GPS全球卫星定位系统使用的坐标系；
        //2. GCJ02：表示经过国测局加密的坐标；
        // 3. BD09：为百度坐标系，其中bd09ll表示百度经纬度坐标，bd09mc表示百度墨卡托米制坐标；
       option.setCoorType("bd09ll");
       // int span=5000;
        // option.setScanSpan(span);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(true);
        option.setIgnoreKillProcess(false);
        option.setEnableSimulateGps(false);
        locationClient.setLocOption(option);
    }
    /**定位**/
    private void showCurrentPosition(BDLocation location){
        baiduMap.setMyLocationEnabled(true);
        MyLocationData locationData=new MyLocationData.Builder()
                .accuracy(location.getRadius())
                .direction(100).latitude(location.getLatitude())
                .longitude(location.getLongitude()).build();
//        MyLocationConfiguration.LocationMode locationMode=MyLocationConfiguration.LocationMode.NORMAL;
//        BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
//        MyLocationConfiguration config = new MyLocationConfiguration(locationMode, true, mCurrentMarker);
//        baiduMap.setMyLocationConfigeration(config);
        baiduMap.setMyLocationData(locationData);
        latitudeLocation=location.getLatitude();
        longitudeLocation=location.getLongitude();
        addressLocation=location.getAddrStr();
        location(latitudeLocation, longitudeLocation);
    }
    /**根据搜索页面地名的经纬度定位**/
    public void onActivityResult(int RequestCode, int ResultCode, Intent data){
        if(RequestCode==0){
            if(ResultCode==1){
                location(Double.parseDouble(data.getStringExtra("latitude")),Double.parseDouble(data.getStringExtra("longitude")));
            }
        }
    }
    @Override
    public void initialUI() {}

    private void getCity() {
        if (addressLocation!=null && addressLocation.equals("")){
            int indexProvince=addressLocation.indexOf("省");
            int indexCity=addressLocation.indexOf("市");
            //tv_search.setText(addressLocation.substring(indexProvince+1,indexCity));
        }
    }





    @Override
    public void onResume() {
        super.onResume();
        //执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        if(locationClient!=null){
            locationClient.stop();
        }
    }

    /**横屏**/
    public void setOrientationLandscape(){
       getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**竖屏**/
    public void setOrientationPortrait(){
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}


