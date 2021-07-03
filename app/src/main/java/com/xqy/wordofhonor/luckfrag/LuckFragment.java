package com.xqy.wordofhonor.luckfrag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.xqy.wordofhonor.R;
import com.xqy.wordofhonor.bean.StarBean;
import com.xqy.wordofhonor.starfrag.StarAnalysisActivity;
import com.xqy.wordofhonor.starfrag.StarBaseAdapter;
import com.xqy.wordofhonor.starfrag.StarPagerAdapter;

import java.util.List;


public class LuckFragment extends Fragment {

    GridView luckGv;
    private List<StarBean.StarinfoBean> mDatas;
    private LuckBaseAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_luck, container, false);
        luckGv = view.findViewById(R.id.luckfrag_gv);
        Bundle bundle = getArguments();
        StarBean infobean = (StarBean) bundle.getSerializable("info");
        mDatas = infobean.getStarinfo();
        adapter = new LuckBaseAdapter(getContext(), mDatas);
//        设置适配器
        luckGv.setAdapter(adapter);
        return view;

    }





}
