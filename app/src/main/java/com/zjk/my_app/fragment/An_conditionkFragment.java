package com.zjk.my_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjk.my_app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 * 车型 按条件界面
 */
public class An_conditionkFragment extends Fragment {


    public An_conditionkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_an_conditionk, container, false);
    }

}
