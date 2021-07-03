package com.xqy.wordofhonor.starfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xqy.wordofhonor.R;
import com.xqy.wordofhonor.bean.StarBean;
import com.xqy.wordofhonor.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarAnalysisActivity extends AppCompatActivity implements View.OnClickListener {
    TextView titleTv;
    ImageView backIv;
    CircleImageView iconIv;
    TextView nameTv;
    ListView analysisLv;
    StarBean.StarinfoBean bean;
    private Map<String, Bitmap> contentlogoImgMap;
    private TextView footerTv;  //ListView底部布局当中需要改变的TextView
    List<StarAnalysisBean> mDatas;
    private AnalysisBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_analysis);
        Intent intent = getIntent();
        bean = (StarBean.StarinfoBean) intent.getSerializableExtra("star");
        initView();
        mDatas = new ArrayList<>();   //初始化显示在ListView上的数据源
        adapter = new AnalysisBaseAdapter(this, mDatas);
        analysisLv.setAdapter(adapter);
        addDataToList();
    }

    private void addDataToList() {
        StarAnalysisBean sab1 = new StarAnalysisBean("演员:", bean.getActor(), R.color.lightblue);
        StarAnalysisBean sab2 = new StarAnalysisBean("身份:", bean.getShenfen(), R.color.lightpink);
        mDatas.add(sab1);
        mDatas.add(sab2);
        //        数据源发生变化，提示适配器更新
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        titleTv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        iconIv = findViewById(R.id.staranalysis_iv);
        nameTv = findViewById(R.id.staranalysis_tv_name);
        analysisLv = findViewById(R.id.staranalysis_lv);
        View footerView = LayoutInflater.from(this).inflate(R.layout.footer_star_analysis, null);
        analysisLv.addFooterView(footerView);
        footerTv = footerView.findViewById(R.id.footerstar_tv_info);

        titleTv.setText("人物简介");
        backIv.setOnClickListener(this);
        nameTv.setText(bean.getName());
        contentlogoImgMap = AssetsUtils.getContentlogoImgMap();
        final Bitmap bitmap = contentlogoImgMap.get(bean.getLogoname());
        iconIv.setImageBitmap(bitmap);
        footerTv.setText(bean.getInfo());
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}