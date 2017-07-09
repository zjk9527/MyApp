package com.zjk.my_app.fragment;





import android.content.Intent;
import android.os.Bundle;


import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.zjk.my_app.R;

import com.zjk.my_app.adapter.MyAdapter;

import com.zjk.my_app.adapter.NewsZuixinAdapter;
import com.zjk.my_app.app_activity.WebViewActivity;
import com.zjk.my_app.app_activity.baoxianActivity;
import com.zjk.my_app.entity.Banner;
import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.entity.News_zuixin;
import com.zjk.my_app.manager.NewsZuixinManager;


import java.util.ArrayList;
import java.util.List;


/**
 * 最新界面
 */
public class Car_news_Fragment extends BaseFragment {

private ViewPager viewPager1;
    private TextView tv_newsimg_title;//轮播图片的名称（在左边显示的）
    private List<ImageView> imageViews;//轮播图片的集合
    private  List<Banner> bannerList;
    private List<View> dotlist;
    private int currentItem=0;   //当前显示的图片的索引
    private View v_dot0;
    private View v_dot1;
    private View v_dot2;
    private View v_dot3;
    private View v_dot4;
    private boolean flag=true;
    private ListView listview_zuixin;
    Handler handler=new Handler();
    FloatingActionButton floating2;
    private SwipeRefreshLayout swipeRefreshLayout=null;
    private MyAdapter adapter1;
    private NewsZuixinAdapter adapter2;//最新新闻的适配器
    private List<News_zuixin.ResultBean.NewslistBean> newslists;



private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_car_news_, container, false);
        Log.i("TAG","onCreate");
        initialUI();
        reset();
       refreshNews(false);
        return view;
    }

    public void initialUI() {
        bannerList=getDefaultBannerList();
        dotlist=new ArrayList<>();
        floating2= (FloatingActionButton) view.findViewById(R.id.floating2);
        viewPager1= (ViewPager) view.findViewById(R.id.viewPager1);
        tv_newsimg_title= (TextView) view.findViewById(R.id.tv_newsimg_title);
        v_dot0=view.findViewById(R.id.v_dot0);
        v_dot1=view.findViewById(R.id.v_dot1);
        v_dot2=view.findViewById(R.id.v_dot2);
        v_dot3=view.findViewById(R.id.v_dot3);
        v_dot4=view.findViewById(R.id.v_dot4);
        dotlist.add(v_dot0);
        dotlist.add(v_dot1);
        dotlist.add(v_dot2);
        dotlist.add(v_dot3);
        dotlist.add(v_dot4);

        floating2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listview_zuixin.smoothScrollToPosition(0);
            }
        });



         //新闻
        // progressDialog=ProgressDialog.show(getActivity(),"数据加载","马上为您呈现最全的新闻");
        //recycleView_zuixin= (RecyclerView) view.findViewById(R.id.recycleView_zuixin);
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swiprefresh_carzuixin);
        swipeRefreshLayout.setColorSchemeResources(R.color.green,R.color.bule,R.color.orange);
        listview_zuixin= (ListView) view.findViewById(R.id.listview_zuixin);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(
                LinearLayoutManager.VERTICAL);
        adapter2 = new NewsZuixinAdapter(getContext());

        listview_zuixin.setAdapter(adapter2);


        //自定义防止swipeRefreshLayout 和listview滑动冲突的方法
          onListViewfocus();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
        listview_zuixin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String path="http://sp.autohome.com.cn/news/news_V3_0.aspx?newsid="
                        +newslists.get(position).getId()+"&pageIndex=1&nightmodel=0&spmodel=0&showad=1";
                Intent intent=new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("path",path);
                startActivity(intent);
            }
        });
    }







    private void onListViewfocus() {
        listview_zuixin.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                boolean enable = false;
            if (listview_zuixin!=null && listview_zuixin.getChildCount()>0){
                //检查列表的第一项是可见的
                boolean firstItemVisible = listview_zuixin.getFirstVisiblePosition() == 0;
                //检查的第一项是可见的
                boolean topOfFirstItemVisible = listview_zuixin.getChildAt(0).getTop() == 0;
                //启用或禁用刷新布局
                enable = firstItemVisible && topOfFirstItemVisible;
            }
                swipeRefreshLayout.setEnabled(enable);
            }
        });
    }

    public void refreshNews(final boolean isClear){
        NewsZuixinManager.loadnews(getContext(),new NewsZuixinManager.News_zuixinLoadListener() {
            @Override
            public void onnewLoadEnd(News_zuixin news_zuixin) {
                Log.i("TAG:2",news_zuixin.toString());
                List<News_zuixin.ResultBean.NewslistBean> newsLists = news_zuixin.getResult().getNewslist();
                Car_news_Fragment.this.newslists=newsLists;
                adapter2.addNews(newslists,isClear);

            }
        });

    }


    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            viewPager1.setCurrentItem(currentItem);
            currentItem=(currentItem+1)% imageViews.size();
            if(flag){
                bannerList=getNewBannerList();
                reset();
                adapter1.notifyDataSetChanged();
                tv_newsimg_title.setText(bannerList.get(0).getTitle());
                flag=false;
            }
            handler.postDelayed(this,2000);
        }
    };
    //重置
    private void reset() {
        imageViews=new ArrayList<>();
        for(int i=0;i<bannerList.size();i++){
            ImageView imageView=new ImageView(getActivity());
            imageView.setImageResource(R.drawable.i);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Constant.getImageLoader().displayImage(bannerList.get(i).getImgUrl(),imageView,
                   Constant.getDisplayImageOptions() );
            imageViews.add(imageView);
            dotlist.get(i).setVisibility(View.VISIBLE);
        }
        adapter1=new MyAdapter(getContext(),imageViews);
        viewPager1.setAdapter(adapter1);
        viewPager1.addOnPageChangeListener(new MyPageChangeListener());
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,2000);
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }




    private class MyPageChangeListener implements ViewPager.OnPageChangeListener{
    private int oldPosition=0;
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
currentItem=position;
        Banner banner=bannerList.get(position);
        tv_newsimg_title.setText(banner.getTitle());
        dotlist.get(oldPosition).setBackgroundResource(R.drawable.dot_blur);
        dotlist.get(position).setBackgroundResource(R.drawable.dot_focus);
        oldPosition=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
    private  List<Banner> getDefaultBannerList(){
        List<Banner> bannerList=new ArrayList<>();
        Banner banner=new Banner();
        banner.setTitle("享受码代码的乐趣");
        banner.setId("0");
        banner.setImgUrl("");
        bannerList.add(banner);
        return bannerList;
    }
    private List<Banner> getNewBannerList(){
        List<Banner> bannerList=new ArrayList<>();
        Banner banner1=new Banner();
        banner1.setTitle("猎豹CS9于上海车展上市 7.68-11.68万元");
        banner1.setImgUrl("http://i0.chexun.net/images/2017/0422/22282/news_0_0_DDCA57836AFBEE610392A2F8007FC39E.jpg");
        bannerList.add(banner1);
        Banner banner2=new Banner();

        banner2.setTitle("720S与570GT龙寅限量版于2017上海车展首发");
        banner2.setImgUrl("http://i2.chexun.net/images/2017/0420/22259/news_0_0_C6EA44293BF0B733C5299D6AE8FF00AD.JPG");
        bannerList.add(banner2);

        Banner banner3=new Banner();
        banner3.setTitle("专访一汽马自达汽车销售副总经理郭德强");
        banner3.setImgUrl("http://i2.chexun.net/images/2017/0421/22259/news_0_0_2641A8CD155D8DD6D527D228CB852D49.jpg");
        bannerList.add(banner3);

        Banner banner4=new Banner();
        banner4.setTitle("2017上海车展：换代凯美瑞概念车正式亮相");
        banner4.setImgUrl("http://i0.chexun.net/images/2017/0421/22259/news_0_0_1FD372EF57694BDAA5A36671BDDA54DB.jpg");
        bannerList.add(banner4);

        Banner banner5=new Banner();
        banner5.setTitle("2017上海国际车展新车图解 新款奔驰S 350L");
        banner5.setImgUrl("http://i2.chexun.net/images/2017/0420/22258/news_0_0_0D81A2E03010A5D580C12CCCE0E80ED4.jpg");
        bannerList.add(banner5);

        return bannerList;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
