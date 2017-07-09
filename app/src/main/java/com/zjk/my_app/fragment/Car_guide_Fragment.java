package com.zjk.my_app.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.CarGuideAdapter;
import com.zjk.my_app.app_activity.WebViewActivity;
import com.zjk.my_app.entity.CarGuide;
import com.zjk.my_app.manager.CarGuideManager;

import java.util.List;

/**
 * 导购界面
 */
public class Car_guide_Fragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView_car_guide;
    View view;
    FloatingActionButton floating1;
    CarGuideAdapter adapter3;
    List<CarGuide.ResultBean.ListBean>carGuideLists;
    public Car_guide_Fragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_car_guide_, container, false);
        initialUI();
        refreshGuide(false);
        return view;
    }


    private void initialUI() {
        floating1= (FloatingActionButton) view.findViewById(R.id.floating1);
        listView_car_guide= (ListView) view.findViewById(R.id.listView_car_guide);
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
       swipeRefreshLayout. setColorSchemeResources(R.color.green,R.color.bule,R.color.orange);
        adapter3=new CarGuideAdapter(getActivity());
        listView_car_guide.setAdapter(adapter3);
        //自定义防止swipeRefreshLayout 和listview滑动冲突的方法
        onListViewfocus();
        //刷新的
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        listView_car_guide.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                String path="http://club.autohome.com.cn/bbs/mobile-c-"+carGuideLists.get(position).
                        getBbsid()+ "-"+carGuideLists.get(position).
                        getTopicid()+ "-1.html?v=3.1&pageSize=20&openlink=0&gprs=0&clientType=Android&r=0.25883239996841656";
                intent.putExtra("path",path);
                startActivity(intent);
            }
        });
        floating1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView_car_guide.smoothScrollToPosition(0);
            }
        });
    }

    private void onListViewfocus() {
        listView_car_guide.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                boolean enable = false;
                if (listView_car_guide!=null && listView_car_guide.getChildCount()>0){
                    //检查列表的第一项是可见的
                    boolean firstItemVisible = listView_car_guide.getFirstVisiblePosition() == 0;
                    //检查的第一项是可见的
                    boolean topOfFirstItemVisible = listView_car_guide.getChildAt(0).getTop() == 0;
                    //启用或禁用刷新布局
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
                swipeRefreshLayout.setEnabled(enable);
            }
        });
    }

    private void refreshGuide(final  boolean isClear) {
        CarGuideManager.loadcarGuide(getContext(), new CarGuideManager.CarGuideLoadListener() {
            @Override
            public void oncarguideLoadEnd(CarGuide carGuide) {
                List<CarGuide.ResultBean.ListBean>carGuidelists=carGuide.
                        getResult().getList();
                Car_guide_Fragment.this.carGuideLists=carGuidelists;
                adapter3.addcarGuide(carGuideLists,isClear);
            }
        });
    }
}
