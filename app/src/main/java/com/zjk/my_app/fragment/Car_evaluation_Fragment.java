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
import com.zjk.my_app.adapter.EvaluationAdapter;
import com.zjk.my_app.app_activity.WebViewActivity;
import com.zjk.my_app.entity.Evaluation;
import com.zjk.my_app.manager.EvaluationManager;

import java.util.List;

/**
 * 资讯 ->评测界面
 * A simple {@link Fragment} subclass.
 */
public class Car_evaluation_Fragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listview_car_evaluation;
    View view;
    EvaluationAdapter adapter4;
    List<Evaluation.ResultBean.DataBean>evaluationLists;
    private FloatingActionButton floatingActionButton;

    public Car_evaluation_Fragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_car_evaluation_, container, false);
        initialUI();
        refreshEvaluation(false);
        return view;
    }



    private void initialUI() {
        floatingActionButton= (FloatingActionButton) view.findViewById(R.id.floating);
       swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        listview_car_evaluation= (ListView) view.findViewById(R.id.listview_car_evaluation);
       swipeRefreshLayout. setColorSchemeResources(R.color.green,R.color.bule,R.color.orange);
        adapter4=new EvaluationAdapter(getActivity());
        listview_car_evaluation.setAdapter(adapter4);
        //自定义防止swipeRefreshLayout 和listview滑动冲突的方法
        onListViewfocus();
       swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        listview_car_evaluation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                String path=evaluationLists.get(position).getUrl();
                intent.putExtra("path",path);
                startActivity(intent);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listview_car_evaluation.smoothScrollToPosition(0);

            }
        });

    }

    private void onListViewfocus() {
        listview_car_evaluation.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                boolean enable = false;
                if (listview_car_evaluation!=null && listview_car_evaluation.getChildCount()>0){
                    //检查列表的第一项是可见的
                    boolean firstItemVisible = listview_car_evaluation.getFirstVisiblePosition() == 0;
                    //检查的第一项是可见的
                    boolean topOfFirstItemVisible = listview_car_evaluation.getChildAt(0).getTop() == 0;
                    //启用或禁用刷新布局
                    enable = firstItemVisible && topOfFirstItemVisible;
            }
                swipeRefreshLayout.setEnabled(enable);
            }
        });
        }
    private void refreshEvaluation(final boolean isClear) {
        EvaluationManager.loadEvaluation(getContext(), new EvaluationManager.EvaluationLoadListener() {
            @Override
            public void onevaluationLoadEnd(Evaluation evaluation) {
                List<Evaluation.ResultBean.DataBean>evaluationlists=evaluation.getResult().getData();
                Car_evaluation_Fragment.this.evaluationLists=evaluationlists;
                adapter4.addevaluation(evaluationLists,isClear);
            }
        });

    }

}
