package com.zjk.my_app.fragment;




import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.AdapterView;

import android.widget.ListView;



import com.zjk.my_app.R;
import com.zjk.my_app.adapter.TrendsAdapter;
import com.zjk.my_app.app_activity.AddActivity;
import com.zjk.my_app.app_activity.logonActivity;

import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.entity.Trends;
import com.zjk.my_app.entity.User;
import com.zjk.my_app.util.LogUtils;
import com.zjk.my_app.util.ToastUtils;
import com.zjk.my_app.view.RefreshLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;




/**
 * 圈子界面
 */
public class CollectiFragment extends Fragment {

    @BindView(R.id.srl_trends) RefreshLayout mRefreshLayout;
    @BindView(R.id.lv_trends) ListView mListView;//信息列表



     TrendsAdapter mAdapter;
     boolean loading = false; // 判断是否在加载更多,避免重复请求网络
     int currentPage = 0; // 当前页面
     List<Trends> trendss = new ArrayList<>();

    static final int STATE_REFRESH = 0; // 下拉刷新
    static final int STATE_MORE = 1; // 加载更多
    int limit = 5; // 每页的数据是5条
    String lastTime;



    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View  view = inflater.inflate(R.layout.fragment_collecti, container, false);
        //获取版本信息是否是6.0等

       ButterKnife.bind(this, view);
        initRefreshLayout();
        return view;
    }



    private void initRefreshLayout() {
        //自定义的下拉刷新动作 （防止listView监听事件与之的冲）
        onListViewfocus();
        // 设置进度动画的颜色
        mRefreshLayout.setColorSchemeResources(android.R.color.holo_green_dark);
        // 设置进度圈的大小,只有两个值:DEFAULT、LARGE
        mRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        // true:下拉过程会自动缩放,230:下拉刷新的高度
        mRefreshLayout.setProgressViewEndTarget(true, 230);

        // 进入页面就执行下拉动画
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                getData(0, STATE_REFRESH);
            }
        });
        // 下拉刷新操作
       mRefreshLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(0, STATE_REFRESH);
            }
        });
        // 上拉加载更多操作
         mRefreshLayout.setOnLoadListener(new RefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                if (!loading) {
                    //mAdapter.setNumber();
                    LogUtils.i("JAVA", "ListView开始加载更多了");
                    loading = true;
                    getData(currentPage,STATE_MORE);
                   // mAdapter.notifyDataSetChanged();
                }
            }
        });
        // ListView条目点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),AddActivity.class);
                startActivity(intent);

            }
        });

        mAdapter = new TrendsAdapter(getActivity(), trendss);
        mListView.setAdapter(mAdapter);
    }

   private void onListViewfocus() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                boolean enable=false;
                if (mListView!=null && mListView.getChildCount()>0 ){
                    //检查listview第一项是否为可见
                    boolean firstItemVisible=mListView.getFirstVisiblePosition()==0;
                    // //检查的第一项是可见的
                    boolean topOfFirstItemVisible = mListView.getChildAt(0).getTop() == 0;
                    //启用或禁用刷新布局
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
                mRefreshLayout.setEnabled(enable);
            }
        });
    }

    /**
     * 分页获取数据
     * @param page 页码
     * @param actionType istView的操作类型（下拉刷新、上拉加载更多）
     */
    public void getData(final int page, final int actionType) {
        BmobQuery<Trends> query = new BmobQuery<>();
        query.order("-createdAt"); // 按时间降序查询
        query.include("author"); // 希望在查询帖子信息的同时也把发布人的信息查询出来
        if(actionType == STATE_MORE) { //加载更多
            // 处理时间查询
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = sdf.parse(lastTime);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            // 只查询小于等于最后一个item发表时间的数据
            query.addWhereLessThanOrEqualTo("createdAt", new BmobDate(date));
            // query.setSkip(page*limit+1); // 跳过之前页数并去掉重复数据
        } else {
            query.setSkip(0);
        }
        query.setLimit(limit);//设置每页数据个数
        //查找数据
        query.findObjects(new FindListener<Trends>() {
            @Override
            public void done(List<Trends> list, BmobException e) {
                if (e==null) {
                    if (list.size()>0) {
                        if(actionType == STATE_REFRESH) {
                            currentPage = 0;
                            trendss.clear();
                        }
                        for (Trends td : list) {
                            trendss.add(td);
                        }
                        currentPage++;
                        mAdapter.notifyDataSetChanged();
                        lastTime = trendss.get(trendss.size()-1).getCreatedAt(); // 获取最后时间
                        if (actionType == STATE_MORE) {
                            mRefreshLayout.setLoading(false); // 结束旋转ProgressBar
                        }
                        LogUtils.i("JAVA", "第"+currentPage+"页数据加载完成");
                    } else if (actionType == STATE_MORE) {
                        ToastUtils.showShort(getActivity(), "没有更多数据了");
                        mRefreshLayout.setLoading(false); // 结束旋转ProgressBar
                    } else if (actionType == STATE_REFRESH) {
                        ToastUtils.showShort(getActivity(), "服务器没有数据");
                    }
                    loading = false;
                    mRefreshLayout.setRefreshing(false); // 请求完成结束刷新状态
                } else {
                    if (actionType == STATE_MORE) {
                        mRefreshLayout.setLoading(false); // 结束旋转ProgressBar
                    }
                    ToastUtils.showShort(getActivity(), "请求服务器异常,请稍后重试");
                    loading = false;
                    mRefreshLayout.setRefreshing(false);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // 登录
            case Constant.RESULT_UPDATE_INFO:
                if (User.getCurrentUser()!=null) {
                    getData(0, STATE_REFRESH);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @OnClick(R.id.iv_add)
    public void onClick(){
        if (User.getCurrentUser()!=null) {
            startActivityForResult(new Intent(getActivity(), AddActivity.class),
                    Constant.RESULT_UPDATE_INFO);
        } else {
            ToastUtils.showShort(getActivity(),"您请先登录");

            startActivityForResult(new Intent(getActivity(),logonActivity.class),Constant.RESULT_UPDATE_INFO);
        }
    }


    public void callPhone(String str){
        Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+str));
        startActivity(intent);

    }
    }

